import java.util.*;

public class oa2 {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, 1};
    System.out.println(solution(arr));
  }
  private static long solution(int[] arr) {
    long res = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) res = res + (i + 1) * (n - i);
    Map<Integer, Integer> numIndex = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (numIndex.containsKey(arr[i])) {
        int lastIndex = numIndex.get(arr[i]);
        res = res - (lastIndex + 1) * (n - i);
      }
      numIndex.put(arr[i], i);
    }
    return res;
  }
}
