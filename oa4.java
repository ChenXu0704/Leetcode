import java.util.*;
public class oa4 {
  public static void main(String[] args) {
    int[] arr = new int[]{3, 6, 2, 5, 25};
    System.out.println(solution(arr));
  }
  private static int solution(int[] arr) {
    Arrays.sort(arr);
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      boolean found = false;
      for (int j = 1; j <= Math.sqrt(arr[i]); j++) {
        if (arr[i] % j != 0) continue;
        int ind = findElementIndex(arr, j);
        if (ind >= 0) {
          res += arr[ind];
          arr[i] = arr[ind];
          found = true;
          break;
        }
        
      }
      if (!found) res += arr[i];
    }
    return res;
  }
  private static int findElementIndex(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) return mid;
      else if (arr[mid] > target) right = mid - 1;
      else left = mid + 1;
    }
    return -1;
  }
}
