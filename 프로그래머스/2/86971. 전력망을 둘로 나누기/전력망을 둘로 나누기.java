import java.util.*;
class Solution {
    private static int N;
    private static ArrayList<ArrayList<Integer>> graph;

    public static int dfs(int x){
        int[] visited = new int[N+1];
        Arrays.fill(visited,0);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int cnt = 1;
        deque.add(x);

        while(!deque.isEmpty()){
            int nx = deque.poll();
            visited[nx] = 1;

            for(int k:graph.get(nx)){
                if(visited[k] == 0){
                    deque.add(k);
                    cnt += 1;
                }
            }
        }

        return cnt;
    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        N = n;
        graph = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<wires.length; i++){
            int[] arr = wires[i];
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }

        for(int[] wire : wires){

            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));

            int node1 = dfs(wire[0]);
            int node2 = dfs(wire[1]);

            answer = Math.min(answer, Math.abs(node1-node2));

            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        return answer;
    }
}