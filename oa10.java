import java.util.*;
public class oa10 {
  public static void main(String[] args) {
    int[] arr = new int[]{2, 1, 3};
    System.out.println(solution(arr));
  }
  private static int solution(int[] arr) {
    Map<Integer, Integer> cnt = new HashMap<>();
    Map<Integer, Integer> sumCnt = new HashMap<>();
    for (int val : arr) cnt.put(val, cnt.getOrDefault(val, 0) + 1);
    int res = 0;
    int[] nums = new int[cnt.keySet().size()];
    int ind = 0;
    for (int val : cnt.keySet()) nums[ind++] = val;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      sumCnt.put(num, sumCnt.getOrDefault(num, 0) + cnt.get(num));
      sumCnt.put(num * 2, sumCnt.getOrDefault(2 * num, 0) + cnt.get(num) / 2);
      for (int j = i + 1; j < nums.length; j++) {
        int curSum = num + nums[j];
        int combine = Math.min(cnt.get(num), cnt.get(nums[j]));
        sumCnt.put(curSum, sumCnt.getOrDefault(curSum, 0) + combine);
      }
    }
    for (int key : sumCnt.keySet()) {
      if (sumCnt.get(key) > res) res = sumCnt.get(key);
    }
    return res;
  }
}
