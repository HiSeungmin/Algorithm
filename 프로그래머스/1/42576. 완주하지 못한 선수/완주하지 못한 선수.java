import java.util.*;
class Solution {
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashmap = new HashMap<>();

        for(String com : completion){
            hashmap.put(com, hashmap.getOrDefault(com, 0)+1);
        }

        for(String person : participant){
            if(hashmap.getOrDefault(person,0) == 0){
                return person;
            }
            hashmap.put(person, hashmap.get(person)-1);
        }
        return null;
    }
}