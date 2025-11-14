import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (a,b)->{
            if(a[2]!=b[2]){
                return a[2] - b[2];
            }
            return 0;
        });

        Set<Integer> set = new HashSet<>();
        set.add(costs[0][0]);

        while (set.size() != n){
            for(int[] cost : costs){
                if(set.contains(cost[0]) && set.contains(cost[1])){
                    continue;
                }
                if(set.contains(cost[0]) || set.contains(cost[1])){
                    set.add(cost[0]);
                    set.add(cost[1]);
                    answer += cost[2];
                    break;
                }
            }
        }
        
        return answer;
    }
}