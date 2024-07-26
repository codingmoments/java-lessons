package booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class to build test data based on string data format
 */
public class TestDataBuilder {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  static {
    OBJECT_MAPPER.findAndRegisterModules();
    OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
  }

  public static <T> List<T> build(String table, Class<T> type) {
    List<T> objectList = new ArrayList<>();
    try {
      String[] tableRows = StringUtils.splitByWholeSeparator(table, "||");

      String[] columnArray = StringUtils.splitByWholeSeparator(tableRows[0], "|");
      List<String> columnList = Arrays.asList(columnArray).stream().map(field -> field.trim()).collect(Collectors.toList());

      for (int i = 1; i < tableRows.length; i++) {
        String[] columnValueArray = StringUtils.splitByWholeSeparator(tableRows[i], "|");
        List<String> columnValueList = Arrays.asList(columnValueArray).stream().map(field -> field.trim()).collect(Collectors.toList());

        if (CollectionUtils.isNotEmpty(columnValueList)) {
          Map<String, String> data = new HashMap<>();
          for (int j = 0; j < columnList.size(); j++) {
            data.put(columnList.get(j), columnValueList.get(j));
          }
          objectList.add(OBJECT_MAPPER.readValue(OBJECT_MAPPER.writeValueAsString(data), type));
        }
      }
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }

    return objectList;
  }

}
