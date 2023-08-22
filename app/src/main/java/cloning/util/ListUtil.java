package cloning.util;

import java.util.List;

public class ListUtil {
  public static boolean areListsEqual(List<?> list1, List<?> list2) {
    if (list1.size() != list2.size()) {
      return false;
    }
    for(Object o1 : list1) {
      for(Object o2 : list2) {
        if(o1 == o2) {
          return false;
        }
      }
    }
    return list1.containsAll(list2);
  }
}
