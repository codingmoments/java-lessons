package cloning.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.AccessFlag;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cloner {

  private static final Set<Class<?>> IMMUTABLE_TYPES = Set.of(Integer.class, Long.class, String.class, LocalDate.class);

  @SuppressWarnings("unchecked")
  public static <T> T deepCopyUsingSerialization(T object) throws Exception {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(object);
      oos.flush();
      oos.close();

      try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray()); ObjectInputStream ois = new ObjectInputStream(bais)) {
        return (T) ois.readObject();
      }

    }
  }

  @SuppressWarnings("unchecked")
  public static <T> T deepCopyUsingReflection(T object) throws Exception {
    if (object == null) {
      return null;
    }
    Class<?> clazz = object.getClass();
    T clone = (T) clazz.getDeclaredConstructor().newInstance();
    Field[] fields = clazz.getDeclaredFields();

    for (Field field : fields) {
      boolean isStaticField = field.accessFlags().stream().anyMatch(f -> f.equals(AccessFlag.STATIC));

      if (isStaticField) {
        continue;
      }

      field.setAccessible(true);
      Class<?> fieldClass = Class.forName(field.get(object).getClass().getName());

      if (field.get(object) instanceof List<?>) {
        List<?> copiedList = deepCopyList((List<?>) field.get(object));
        field.set(clone, copiedList);
      }
      else if (isImmutableType(fieldClass)) {
        field.set(clone, field.get(object));
      }
      else {
        field.set(clone, deepCopyUsingReflection(field.get(object)));
      }
    }
    return clone;
  }

  private static <T> List<T> deepCopyList(List<T> arg) throws Exception {
    if (arg == null) {
      return null;
    }
    List<T> retList = new ArrayList<T>();
    for (T each : arg) {
      retList.add(deepCopyUsingReflection(each));
    }
    return retList;
  }

  private static boolean isImmutableType(Class<?> clazz) {
    return IMMUTABLE_TYPES.contains(clazz);
  }
}
