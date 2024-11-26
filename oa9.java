import java.util.*;
public class oa9 {
  public static void main(String[] args) {
    int[] arr = new int[]{3, 4, 1, 2, 2, 1, 1};
    System.out.println(Arrays.toString(solution(arr)));
  } 
  private static int[] solution(int[] arr) {
    Map<Integer, PriorityQueue<Integer>> cnt = new TreeMap<>();
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      if (!cnt.containsKey(val)) cnt.put(val, new PriorityQueue<>());
      cnt.get(val).offer(i);
    }
    for (int key : cnt.keySet()) {
      if (cnt.get(key).size() < 2) continue;
      PriorityQueue<Integer> nums = cnt.get(key);
      while (nums.size() >= 2) {
        int firstInd = nums.poll(), secondInd = nums.poll();
        if (!cnt.containsKey(2 * key)) cnt.put(2 * key, new PriorityQueue<>());
        cnt.get(2 * key).offer(2 * key);
        arr[firstInd] = -1;
        arr[secondInd] = 2 * key;
      }
    }
    int curInd = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) continue;
      arr[curInd++] = arr[i];
    }
    return Arrays.copyOfRange(arr, 0, curInd);
  } 
  
}

