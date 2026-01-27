import java.util.*;

class Solution {
    int[] arr = new int[5];
    boolean[] visited;
    Set<Integer>[] set;
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        set = new Set[q.length];
        for(int i = 0; i < q.length; i++){
            set[i] = new HashSet<>();
            for(int j = 0; j < 5; j++){
                set[i].add(q[i][j]);
            }
        }
        
        visited = new boolean[n + 1];
        backTrack(0, 1, n, q, ans);
        return answer;
    }
    
    public void backTrack(int depth, int cur, int n, int[][] q, int[] ans){
        if(depth == 5){
            if(isValid(q, ans)){
                answer++;
            }
            return;
        }

        for(int i = cur; i <= n; i++){
            if(visited[i])
                continue;
            arr[depth] = i;
            visited[i] = true;
            backTrack(depth + 1, i + 1, n, q, ans);
            visited[i] = false;
        }
    }
    
    public boolean isValid(int[][] q, int[] ans){
        for(int i = 0; i < q.length; i++){
            int sum = 0;
            for(int num : arr){
                if(set[i].contains(num))
                    sum++;
            }
            
            if(ans[i] != sum)
                return false;
        }
        
        return true;
    }
}