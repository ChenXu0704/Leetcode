public class oa7 {
  public static void main(String[] args) {
    String str = "23232";
    int k = 2;
    System.out.println(solution(str.toCharArray(), k));
  }
  private static boolean solution(char[] arr, int k) {
    int n = arr.length;
    for (int i = 0; i <= n - k - 1; i++) {
      if (arr[i] != arr[i + k]) return false;
    }
    return true;
  }
}
