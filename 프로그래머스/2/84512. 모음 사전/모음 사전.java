import java.util.*;
class Solution {
    private static char[] alp = {'A', 'E', 'I', 'O', 'U'};
    private static List<String> dict = new ArrayList<>();

    public static int solution(String word) {
        make_dictionary("");
        return dict.indexOf(word);

    }

    private static void make_dictionary(String str){

        if(str.length()<5){
            dict.add(str);
        }
        if(str.length() == 5){
            dict.add(str);
            return;
        }

        for(int i=0; i<5; i++){
            make_dictionary(str+alp[i]);
        }
    }
}