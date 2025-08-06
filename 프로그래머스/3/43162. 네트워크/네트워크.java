import java.util.*;

class Solution {
    static int[] visited;
    static List<List<Integer>> arr;
    public static void bfs(int k){
        visited[k]=1;

        for(int i : arr.get(k)){
            if(visited[i]==0){
                bfs(i);
            }
        }
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        arr = new ArrayList<>();

        for(int i=0; i<n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<n; j++){
                if(i!=j && computers[i][j]==1){
                    row.add(j);
                }
            }
            arr.add(row);
        }

        for(int k=0; k<n; k++){
            if(visited[k]==0){
                bfs(k);
                answer += 1;
            }
        }

        return answer;
    }
}