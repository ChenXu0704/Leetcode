import java.util.*;
public class oa6 {
  public static void main(String[] args) {
    int[] arr = new int[]{2, 1, 3, 4, 3};
    System.out.println(solution(arr));
  }
  private static int solution(int[] arr) {
    Arrays.sort(arr);
    int res = 0, currentBrightness = 0;
    for (int val : arr) {
      if (currentBrightness > val) res++;
      else currentBrightness += val;
    }
    return res;
  }
  
}
