import java.util.*;
class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static int dfs(int[] start, int[] target, String[] maps){
        int[][] visited = new int[maps.length][maps[0].length()];
        Deque<int[]> deque = new ArrayDeque<>();

        deque.add(start);

        while(!deque.isEmpty()){
            int[] a = deque.pop();
            int x = a[0];
            int y = a[1];

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(0<=nx && nx<maps.length && 0<=ny && ny<maps[0].length() && maps[nx].charAt(ny)!='X'){
                    if(visited[nx][ny] == 0){
                        visited[nx][ny] = visited[x][y]+1;
                        deque.add(new int[]{nx,ny});
                    }
                }
            }

        }

        for(int i=0; i<visited.length; i++){
            System.out.println(Arrays.toString(visited[i]));
        }
        System.out.println();
        return visited[target[0]][target[1]];
    }

    public static int solution(String[] maps) {
        int[] S = new int[2];
        int[] L = new int[2];
        int[] E = new int[2];

        for(int i=0; i<maps.length; i++){
            String str = maps[i];
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == 'S'){
                    S[0] = i;
                    S[1] = j;
                }
                if(str.charAt(j) == 'L'){
                    L[0] = i;
                    L[1] = j;
                }
                if(str.charAt(j) == 'E'){
                    E[0] = i;
                    E[1] = j;
                }
            }
        }


        int cnt = dfs(S, L, maps);
        if (cnt == 0){
            return -1;
        }

        int cnt2 = dfs(L, E, maps);
        if(cnt2 == 0){
            return -1;
        }
        return cnt+cnt2;
    }
}