public class oa1 {
  public static void main(String[] args) {
    int[] arr = new int[]{3, -2, 5, -6, 1};
    int res = solution(arr);
    System.out.println(res);
    System.out.println(dp(arr));
  }
  public static int solution(int[] arr) {
    int res = 0;
    int dp = 0, max_neg = 0;
    boolean applied_oper = false;
    for (int i = 0; i < arr.length; i++) {
      dp += arr[i];
      max_neg = Math.min(max_neg, arr[i]);
      if (dp < 0) {
        if (applied_oper) return res;
        else {
          applied_oper = true;
          dp = dp - 2 * max_neg; 
          res = i + 1;
        }
      }
      else res = i + 1;
    }
    return res;
  }
  private static int dp(int[] arr) {
    int[] dp = new int[2];
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      int prev = dp[0];
      if (dp[0] >= 0) {
        dp[0] += arr[i];
        dp[1] = Math.max(dp[1] + arr[i], prev - arr[i]);
      }
      else {
        dp[1] = dp[1] + arr[i]; 
      }
      if (dp[0] < 0 && dp[1] < 0) return res;
      else res++;
    }
    return res;
  }
}
