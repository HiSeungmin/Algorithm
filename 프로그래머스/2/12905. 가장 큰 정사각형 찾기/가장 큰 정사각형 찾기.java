class Solution
{
    public static int solution(int [][]board)
    {
        int answer = 0;
        int N = board.length;
        int M = board[0].length;
        int[][] dp = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 1){
                    if(i==0 || j==0){
                        dp[i][j] = 1;
                    }else{
                        int a = Math.min(dp[i-1][j], dp[i][j-1]);
                        dp[i][j] = Math.min(a, dp[i-1][j-1]) + 1;
                    }
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return (int)Math.pow(answer, 2);
    }
}