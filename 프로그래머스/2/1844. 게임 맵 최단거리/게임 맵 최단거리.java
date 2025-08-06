import java.util.*;
class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static int solution(int[][] maps) {
        int answer = 0;
        int size_x = maps.length;
        int size_y = maps[0].length;

        int[][] visited = new int[size_x][size_y];

        for(int i=0; i<size_x; i++){
            for(int j=0; j<size_y; j++){
                visited[i][j] = 0;
            }
        }
        visited[0][0] = 1;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0,0});

        while(!deque.isEmpty()){
            int[] arr = deque.pop();
            int x = arr[0];
            int y = arr[1];

            for(int k=0; k<4; k++){
                int nx = dx[k] + x;
                int ny = dy[k] + y;

                if(0<=nx && nx<size_x && 0<=ny && ny<size_y && maps[nx][ny]==1){
                    if(visited[nx][ny] == 0){
                        visited[nx][ny] += visited[x][y]+1;
                        deque.add(new int[]{nx,ny});
                    }
                }
            }
        }

        if(visited[size_x-1][size_y-1] == 0){
            return -1;
        }else{
            return visited[size_x-1][size_y-1];
        }
    }
}