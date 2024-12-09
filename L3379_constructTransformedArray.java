import java.util.*;
public class L3379_constructTransformedArray {
  public static void main(String[] Args) {
    int[] arr = new int[]{3,-2,1,1};
    System.out.println(Arrays.toString(solution(arr)));
  }
  private static int[] solution(int[] nums) {
    int[] res = new int[nums.length];
    int l = nums.length;
    for (int i = 0; i < l; i++) {
      if (nums[i] == 0) res[i] = 0;
      else if (nums[i] > 0) res[i] = nums[(i + nums[i]) % l];
      else res[i] = nums[(i - Math.abs(nums[i]) % l + l) % l];
    }
    return res;
  }
}
