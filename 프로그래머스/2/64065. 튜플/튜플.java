import java.util.*;
class Solution {
    public static int[] solution(String s) {
        List<Integer> set = new ArrayList<>();

        s = s.substring(2, s.length()- 2).replace("},{", "-");

        String[] arr = s.split("-");
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        for(int i=0; i<arr.length; i++){
            String[] strArray = arr[i].split(",");

            for(String st : strArray){
                int num = Integer.parseInt(st);
                if(!set.contains(num))
                    set.add(num);
            }
        }

        int[] answer = new int[set.size()];
        int k=0;
        for(int num : set){
            answer[k++] = num;
        }

        return answer;
    }
}