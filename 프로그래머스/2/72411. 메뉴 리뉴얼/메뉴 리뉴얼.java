import java.util.*;
class Solution {
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        courseMap = new HashMap<>();

        for(int i:course){
            courseMap.put(i, new HashMap<>());
        }

        for(String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }

        for (int len : course) {
            HashMap<String, Integer> map = courseMap.get(len);
            int max = 0;

            for (int count : map.values()) {
                if (count > max) max = count;
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max && max > 1) {
                    pq.offer(key);
                }
            }
        }

        String[] answer = new String[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) answer[i++] = pq.poll();
        return answer;
    }

    public static void combinations(int idx, char[] order, String result){
        if(courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0)+1);
        }

        for(int i = idx; i<order.length; i++){
            combinations(i+1, order, result+order[i]);
        }
    }
}