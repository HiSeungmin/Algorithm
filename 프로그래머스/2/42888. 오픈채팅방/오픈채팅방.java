import java.util.*;
class Solution {
    public static String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();

        int idx = 0;

        for(int i=0; i<record.length; i++){
            String[] array = record[i].split(" ");
            if(Objects.equals(array[0], "Enter") || Objects.equals(array[0], "Change")){
                userMap.put(array[1], array[2]);
            }
            if(Objects.equals(array[0], "Enter") || Objects.equals(array[0], "Leave")){
                idx+=1;
            }
        }
        String[] answer = new String[idx];
        int i = 0;
        for(int k=0; k<record.length; k++){
            String[] array = record[k].split(" ");
            if(Objects.equals(array[0], "Enter")){
                answer[i++] = userMap.get(array[1]) +"님이 들어왔습니다.";
            }else if(Objects.equals(array[0], "Leave")){
                answer[i++] = userMap.get(array[1]) +"님이 나갔습니다.";
            }
        }
        return answer;
    }
}