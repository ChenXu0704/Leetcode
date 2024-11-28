import java.util.Arrays;

public class L3366_Minimum_Array_Sum {
  private static int res = Integer.MAX_VALUE;
  public static void main(String[] Args) {
    int[] arr = new int[]{2,8,3,19,3};
    int k = 3, op1 = 1, op2 = 1;
    minArraySum(arr, k, op1, op2);
    System.out.println(res);
  }
  
  private static int minArraySum(int[] nums, int k, int op1, int op2) {
    int[][][] dp = new int[nums.length][op1 + 1][op2 + 1];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j <= op1; j++) Arrays.fill(dp[i][j], Integer.MAX_VALUE);
    }
    dfs(nums, 0, k, op1, op2, dp);
    return res;
  }
  private static int dfs(int[] nums, int ind, int k, int curO1, int curO2, int[][][] dp) {
    if (ind == nums.length) return 0;
    if (dp[ind][curO1][curO2] != Integer.MAX_VALUE) return dp[ind][curO1][curO2];
    int val = dfs(nums, ind + 1, k, curO1, curO2, dp) + nums[ind];
    if (curO1 > 0) val = Math.min(val, dfs(nums, ind + 1, k, curO1 - 1, curO2, dp) + (nums[ind] + 1) / 2);
    if (curO2 > 0 && nums[ind] >= k) {
        val = Math.min(val, dfs(nums, ind + 1, k, curO1, curO2 - 1, dp) + (nums[ind] - k));
        if (curO1 > 0) {
            val = Math.min(val, dfs(nums, ind + 1, k, curO1 - 1, curO2 - 1, dp) + (nums[ind] - k + 1) / 2);
            if ((nums[ind] + 1) / 2 >= k)
                val = Math.min(val, dfs(nums, ind + 1, k, curO1 - 1, curO2 - 1, dp) + (nums[ind] + 1) / 2 - k);
            
        } 
    }
    dp[ind][curO1][curO2] = val;
    if (ind == 0) res = Math.min(res, val);
    return val;
}
  
}
