import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> a = new ArrayList<>();
        int k = 1;
        int p = (int) Math.ceil((100.0 - progresses[0])/speeds[0]);

        for(int i=1; i<progresses.length; i++){
            int d = (int) Math.ceil((100.0 - progresses[i])/speeds[i]);
            if(p >= d){
                k+=1;
            }else{
                a.add(k);
                p = d;
                k = 1;
            }
        }
        a.add(k);

        int[] answer = new int[a.size()];
        for(int i = 0; i<a.size(); i++){
            answer[i] = a.get(i);
        }

        return answer;
    }
}