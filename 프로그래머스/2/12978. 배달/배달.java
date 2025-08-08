import java.util.*;
class Solution {
    static final int INF = (int) 1e9;

    public static int solution(int N, int[][] road, int K) {
        int answer=0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));


        for(int i=0; i<N+1; i++){
            graph.add(new ArrayList<>());
        }


        for (int[] arr : road) {
            int from = arr[0];
            int to = arr[1];
            int cost = arr[2];

            graph.get(from).add(new int[]{to, cost});
            graph.get(to).add(new int[]{from, cost});
        }

        dist[1] = 0;
        pq.add(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int costSoFar = cur[1];

            if (costSoFar > dist[node]) continue;

            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextCost = costSoFar + next[1];

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new int[]{nextNode, nextCost});
                }
            }
        }

        for(int r : dist){
            if(K>=r){
                answer += 1;
            }
        }
        return answer;
    }
}