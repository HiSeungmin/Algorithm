import java.util.*;
class Solution {
    public static class Node{
        int x;
        int y;
        int direction;
        int cost;
        public Node(int x, int y, int direction, int cost){
            this.x=x;
            this.y=y;
            this.direction=direction;
            this.cost=cost;
        }
    }

    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[][] graph;
    private static int N;
    private static int[][][] visited;

    private static boolean isValid(int x, int y){
        return 0<=x && x<N && 0<=y && y<N;
    }

    private static boolean isBlocked(int x, int y){
        return graph[x][y]==1;
    }

    private static int calculator(int direction, int prevDirection, int cost){
        if(direction == -1 || (prevDirection-direction)%2==0){
            return cost+100;
        }
        return cost+600;
    }

    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        N = board.length;
        graph = board;
        visited = new int[N][N][4];
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, -1, 0));

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];

                if(!isValid(nx,ny)|| isBlocked(nx,ny)){
                    continue;
                }

                int newCost = calculator(now.direction, i, now.cost);

                if(nx == N-1 && ny == N-1){
                    answer = Math.min(answer, newCost);
                }else if (visited[nx][ny][i] == 0 || visited[nx][ny][i] > newCost){
                    queue.add(new Node(nx,ny,i,newCost));
                    visited[nx][ny][i] = newCost;
                }

            }
        }
        return answer;
    }
}