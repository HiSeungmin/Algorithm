import java.util.*;
class Solution {
    static class Edge {
        int to;
        int type;

        Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

    int n, k;
    List<List<Edge>> graph;
    int answer = 0;

    public int solution(int n, int infection, int[][] edges, int k) {

        this.n = n;
        this.k = k;

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] e : edges) {

            int a = e[0];
            int b = e[1];
            int type = e[2];

            graph.get(a).add(new Edge(b, type));
            graph.get(b).add(new Edge(a, type));
        }

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        dfs(0, infected);

        return answer;
    }

    void dfs(int step, boolean[] infected) {

        int count = 0;
        for (int i = 1; i <= n; i++)
            if (infected[i]) count++;

        answer = Math.max(answer, count);

        if (step == k) return;

        for (int type = 1; type <= 3; type++) {

            boolean[] newInfected = infected.clone();

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= n; i++)
                if (newInfected[i])
                    q.add(i);

            while (!q.isEmpty()) {

                int cur = q.poll();

                for (Edge next : graph.get(cur)) {

                    if (next.type != type) continue;

                    if (!newInfected[next.to]) {
                        newInfected[next.to] = true;
                        q.add(next.to);
                    }
                }
            }

            dfs(step + 1, newInfected);
        }
    }
}