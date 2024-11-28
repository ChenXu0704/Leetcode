import java.util.*;
public class L3364_minimumSumSubarray {
  public static void main(String[] args) {
    int[] input = new int[]{3, -2, 1, 4};
    List<Integer> arr = new ArrayList<>();
    for (int val : input) arr.add(val);
    int l = 2, r = 3;  
    System.out.println(solution(arr, l, r));
  }
  private static int solution(List<Integer> nums, int l, int r) {
    int res = Integer.MAX_VALUE;
    nums.add(0, 0);
    for (int i = 1; i < nums.size(); i++) nums.set(i, nums.get(i - 1) + nums.get(i));
    for (int i = 1; i <= nums.size(); i++) {
      for (int j = i + l - 1; j < nums.size(); j++) {
        if (j - i + 1 > r) break;
        if (nums.get(j) - nums.get(i - 1) > 0) res = Math.min(res, nums.get(j) - nums.get(i - 1));
      }
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }

}
