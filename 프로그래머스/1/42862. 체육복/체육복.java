import java.util.*;
class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] people = new int[n+2];
        people[0] = -1;

        for(int l : lost)
            people[l] -= 1;
        for(int r : reserve)
            people[r] += 1;

        for(int i=1; i<n+1; i++){
            if(people[i]>=0){
                continue;
            }else if(people[i] == -1 && people[i-1] >0){
                people[i] += 1;
                people[i-1] -= 1;
            }else if(people[i] == -1 && people[i+1] >0){
                people[i] += 1;
                people[i+1] -= 1;
            }else{
                answer -= 1;
            }
        }

        return answer;
    }
}