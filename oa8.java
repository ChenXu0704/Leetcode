import java.util.*;
public class oa8 {
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5};
    int k = 2;
    System.out.println(solution(arr, k));
  }
  private static int solution(int[] arr, int k) {
    int n = arr.length;
    double[][][] dp = new double[n][n][k + 1];
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        Arrays.fill(dp[i][j], Double.MIN_VALUE);
        dp[i][j][0] = 0.0;
        dp[i][j][1] = getMedian(Arrays.copyOfRange(arr,i, j + 1));
      }
    }
    for (int s = 2; s <= k; s++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
          dp[0][i][s] = Math.max(dp[0][i][s], dp[0][j][s - 1] + dp[j + 1][i][1]);
        }
      }
    }
    //System.out.println(Arrays.deepToString(dp));
    return (int) Math.round(dp[0][n - 1][k]);
  }
  private static double getMedian(int[] arr) {
    Arrays.sort(arr);
    //System.out.println(Arrays.toString(arr));
    return arr.length % 2 == 1 ? arr[arr.length / 2] : (double) (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
  }
}
