import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long total=0;//두큐의합
        long q1Sum=0;//1번큐의합
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        for(int i=0; i<queue1.length; i++) {
            total += queue1[i]+queue2[i];
            q1Sum += queue1[i];
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        if(total%2!=0) return -1;//만약 두큐의합이 홀수면 같게 못만듦.

        long target = total/2;
        while(true) {
            if(answer>(queue1.length+queue2.length)*2) return -1;//이땐 더 순회해도 못만듦
            if(q1Sum==target) break;
            else if(q1Sum>target) {
                q1Sum-=q1.peek();
                q2.add(q1.poll());
            }else {
                q1Sum += q2.peek();
                q1.add(q2.poll());
            }
            answer++;
        }

        return answer;

    }
}