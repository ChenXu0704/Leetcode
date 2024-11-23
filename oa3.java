import java.util.*;
public class oa3 {
  public static void main(String[] args) {
    int[] arr = new int[]{5,3,2,3,4};
    int m = 2;
    System.out.println(Arrays.toString(solution(arr, m)));
  }
  private static int[] solution(int[] arr, int m) {
    List<Integer> res = new ArrayList<>();
    int n = arr.length;
    int[] left = new int[n];
    int[] right = new int[n];
    left[0] = 1;
    right[n - 1] = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] <= arr[i - 1]) left[i] = left[i - 1] + 1;
      else left[i] = 1;
      if (arr[n - 1 - i] <= arr[n - i]) right[n - 1 - i] = right[n - i] + 1;
      else right[n - 1 - i] = right[n - i];
    }
    for (int i = m; i <= n - 1 - m; i++) {
      if (left[i] >= m && right[i] >= m) res.add(i);
    }
    int[] ret = new int[res.size()];
    for (int i = 0; i < res.size(); i++) ret[i] = res.get(i) + 1;
    return ret;
  }
}