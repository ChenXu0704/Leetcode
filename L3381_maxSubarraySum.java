import java.util.HashMap;
import java.util.Map;

public class L3381_maxSubarraySum {
  public static void main(String[] Args) {
    int[] arr = new int[]{1,2};
    int k = 1;
    System.out.println(solution(arr, k));
  }
  private static long solution(int[] nums, int k) {
    Map<Integer, Long> prefix = new HashMap<>();
    long curSum = 0L;
    prefix.put(0, 0L);
    long res = Long.MIN_VALUE;
    for (int i = 1; i <= nums.length; i++) {
      curSum += nums[i - 1];
      if (prefix.containsKey(i % k)) {
        res = Math.max(res, curSum - prefix.get(i % k));
        prefix.put(i % k, Math.min(prefix.get(i % k), curSum));
      }
      else prefix.put(i % k, curSum);
    }
    return res;
  }
}
