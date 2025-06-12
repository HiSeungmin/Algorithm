import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;

        Deque<Integer> q = new ArrayDeque<>();
        Deque<Integer> idx = new ArrayDeque<>();

        List<Integer> lst = Arrays.stream(priorities)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        for(int i=0; i<priorities.length; i++){
            q.add(priorities[i]);
            idx.add(i);
        }

        while(lst.size()>0){
            int x = q.removeFirst();
            int y = idx.removeFirst();
            if(x == lst.get(lst.size()-1)){
                lst.remove(lst.size() - 1);
                if(y==location){
                    return answer;
                }
                answer += 1;
            }else{
                q.add(x);
                idx.add(y);
            }
        }
        return answer;
    }
}