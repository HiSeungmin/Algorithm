import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        int last = arr[0];
        for(int i=1; i< arr.length; i++){
            if(last != arr[i]) {
                answer.add(arr[i]);
                last = arr[i];
            }
        }

        int[] ret = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ret[i] = answer.get(i);
        }

        return ret;
    }
}