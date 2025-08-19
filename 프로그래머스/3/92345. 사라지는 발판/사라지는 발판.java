class Solution {
    private static int[][] block = new int[5][5];
    private static boolean[][] visited = new boolean[5][5];

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int n;
    private static int m;

    private static boolean OOB(int x, int y){
        return x<0 || x>=n || y<0 || y>=m;
    }

    private static int solve(int curX, int curY, int opX, int opY){
        if(visited[curX][curY]) return 0;
        int ret = 0;

        for(int dir=0; dir<4; dir++){
            int nx = curX + dx[dir];
            int ny = curY + dy[dir];

            if(OOB(nx, ny) || visited[nx][ny] || block[nx][ny] == 0) continue;

            visited[curX][curY] = true;
            int val = solve(opX, opY, nx, ny)+1;
            visited[curX][curY] = false;

            if(ret%2==0 && val%2==1) ret = val;
            else if(ret%2==0 && val%2==0) ret = Math.max(ret, val);
            else if(ret%2==1 && val%2==1) ret = Math.min(ret, val);
        }
        return ret;
    }

    public static int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        block = board;
        return solve(aloc[0], aloc[1] , bloc[0], bloc[1]);
    }
}