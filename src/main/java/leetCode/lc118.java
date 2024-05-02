package leetCode;

import java.util.ArrayList;
import java.util.List;

public class lc118 {
  public static void main(String[] args) {
    generate(5);
  }

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();

    for (int i = 0; i < numRows; i++) {
      List<Integer> row = new ArrayList<Integer>();
      for (int j = 1; j <= i; j++) {
        if (j == 1 || j == i) {
          row.add(1);
        } else {
          row.add(ret.get(i - 1).get(j-1 ) + ret.get(i - 1).get(j));
        }
      }
      ret.add(row);
    }
    return ret;
  }
}
