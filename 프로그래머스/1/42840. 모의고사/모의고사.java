import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] std1 = {1,2,3,4,5};
        int[] std2 = {2,1,2,3,2,4,2,5};
        int[] std3 = {3,3,1,1,2,2,4,4,5,5};

        int[] scores = new int[3];

        for(int i=0; i<answers.length; i++){
            if(answers[i] == std1[i%std1.length]) scores[0]++;
            if(answers[i] == std2[i%std2.length]) scores[1]++;
            if(answers[i] == std3[i%std3.length]) scores[2]++;
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<scores.length; i++){
            if(scores[i] == maxScore){
                answer.add(i+1);
            }
        }

        int[] ans = new int[answer.size()];
        int idx = 0;
        for(int i:answer){
            ans[idx++] = i;
        }
        return ans;
    }
}