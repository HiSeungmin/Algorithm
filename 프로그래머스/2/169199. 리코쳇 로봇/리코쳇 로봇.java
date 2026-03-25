import java.util.*;

class Solution {
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    public int solution(String[] board) {
        int N = board.length;
        int M = board[0].length();

        char[][] map = new char[N][M];
        int[] start = new int[3];

        for(int i=0; i<N; i++){
            char[] c = board[i].toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = c[j];
                if(c[j] == 'R'){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }


        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[start[0]][start[1]] = true;
        que.add(start);

        while(!que.isEmpty()){
            int[] a = que.poll();

            for(int k = 0; k<4; k++){
                int nx = a[0] + dx[k];
                int ny = a[1] + dy[k];

                while(0<=nx && nx<N && ny>=0 && ny<M && map[nx][ny] != 'D'){
                    nx += dx[k];
                    ny += dy[k];
                }
                nx -= dx[k];
                ny -= dy[k];

                if (map[nx][ny] == 'G') {
                    return a[2] + 1;
                }

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny, a[2]+1});
                }
            }
        }

        return -1;
    }
}