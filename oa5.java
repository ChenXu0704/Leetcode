import java.util.*;
public class oa5 {
  public static void main(String[] args) {
    int[] arr = new int[]{- 2, 1 , 0};
    int d = 8;
    System.out.println(solution(arr, d));
  }
  private static int solution(int[] arr, int d) {
    int n = arr.length;
    int left = getMin(arr, arr[n / 2], d);
    int right = getMax(arr, arr[n / 2], d);
    return right - left + 1;
  }
  private static int getMin(int[] arr, int anchor, int d) {
    int l = -1000000000, r = anchor;
    while (l < r) {
      int m = l + (r - l) / 2;
      if (isGood(arr, m, d)) r = m;
      else l = m + 1;
    }
    return l;
  }
  private static int getMax(int[] arr, int anchor, int d) {
    int l = anchor, r = 1000000000;
    while (l < r) {
      int m = l + (r - l) / 2 + 1;
      if (isGood(arr, m, d)) l = m;
      else r = m - 1;
    }
    return l;
  }
  private static boolean isGood(int[] arr, int x, int d) {
    int total = 0;
    for (int val : arr) {
      total += Math.abs(x - val) * 2;
      if (total > d) return false;
    }
    return true;
  }
}
