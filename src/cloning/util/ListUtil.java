package cloning.util;

import java.util.List;

public class ListUtil {
  public static boolean areListsDeepEqual(List<?> list1, List<?> list2) {
    if (list1.size() != list2.size()) {
      return false;
    }
    for (Object o1 : list1) {
      for (Object o2 : list2) {
        // If both references point to same object, we return false.
        if (o1 == o2) {
          return false;
        }
      }
    }
    return list1.containsAll(list2);
  }
}
