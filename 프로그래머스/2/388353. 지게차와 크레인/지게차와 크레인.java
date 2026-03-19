import java.util.*;

class Solution {
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        
        char[][] map = new char[n+2][m+2];
        
        for(int i=0;i<n+2;i++){
            Arrays.fill(map[i], '*');
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }

        for(String req : requests){
            char ch = req.charAt(0);

            if(req.length() == 2){
                for(int i=1;i<=n;i++){
                    for(int j=1;j<=m;j++){
                        if(map[i][j] == ch){
                            map[i][j] = '*';
                        }
                    }
                }
            } else {
                boolean[][] visited = new boolean[n+2][m+2];
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{0,0});
                visited[0][0] = true;

                boolean[][] remove = new boolean[n+2][m+2];

                while(!q.isEmpty()){
                    int[] cur = q.poll();

                    for(int d=0; d<4; d++){
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];

                        if(nx<0 || ny<0 || nx>=n+2 || ny>=m+2) continue;
                        if(visited[nx][ny]) continue;

                        visited[nx][ny] = true;

                        if(map[nx][ny] == '*'){
                            q.add(new int[]{nx,ny});
                        } else if(map[nx][ny] == ch){
                            remove[nx][ny] = true;
                        }
                    }
                }

                for(int i=1;i<=n;i++){
                    for(int j=1;j<=m;j++){
                        if(remove[i][j]){
                            map[i][j] = '*';
                        }
                    }
                }
            }
        }

        int answer = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(map[i][j] != '*'){
                    answer++;
                }
            }
        }

        return answer;
    }
}