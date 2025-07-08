import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String name = cloth[0];
            String category = cloth[1];

            map.putIfAbsent(category, new ArrayList<>());
            map.get(category).add(name);
        }

        int result = 1;
        for(String key : map.keySet()){
            result *= map.get(key).size()+1;
        }

        return result-1;
    }
}