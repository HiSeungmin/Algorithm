import java.util.*;
class Solution {
    static class Edge {
        int to;
        int type;
        int idx;

        Edge(int to, int type, int idx) {
            this.to = to;
            this.type = type;
            this.idx = idx;
        }
    }

    int n, k;
    List<List<Edge>> graph;
    int answer = 0;

    public int solution(int n, int infection, int[][] edges, int k) {

        this.n = n;
        this.k = k;

        graph = new ArrayList<>();

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){

            int a = edges[i][0];
            int b = edges[i][1];
            int type = edges[i][2];

            graph.get(a).add(new Edge(b,type,i));
            graph.get(b).add(new Edge(a,type,i));
        }

        boolean[] infected = new boolean[n+1];
        infected[infection] = true;

        boolean[] usedEdge = new boolean[edges.length];

        dfs(0, infected, usedEdge);

        return answer;
    }

    void dfs(int step, boolean[] infected, boolean[] usedEdge){

        int count = 0;

        for(int i=1;i<=n;i++)
            if(infected[i]) count++;

        answer = Math.max(answer, count);

        if(step == k) return;

        for(int type=1; type<=3; type++){

            boolean[] newInfected = infected.clone();
            boolean[] newUsed = usedEdge.clone();

            Queue<Integer> q = new LinkedList<>();

            for(int i=1;i<=n;i++)
                if(newInfected[i])
                    q.add(i);

            while(!q.isEmpty()){

                int cur = q.poll();

                for(Edge next : graph.get(cur)){

                    if(next.type != type) continue;
                    if(newUsed[next.idx]) continue;

                    newUsed[next.idx] = true;

                    if(!newInfected[next.to]){
                        newInfected[next.to] = true;
                        q.add(next.to);
                    }
                }
            }
            dfs(step+1, newInfected, newUsed);
        }
    }
}