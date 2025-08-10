class Solution {
    public static int solution(int n) {
        int[] board = new int[n];
        return placeQueen(board, 0, n);
    }

    private static int placeQueen(int[] board, int row, int n){
        if(row==n){
            return 1;
        }

        int count = 0;
        for(int col=0; col<n; col++){
            board[row] = col;
            if(isSafe(board, row)){
                count += placeQueen(board, row+1, n);
            }
        }
        return count;
    }

    private static boolean isSafe(int[] board, int row){
        for(int prev=0; prev < row; prev++){
            if(board[prev] == board[row] || Math.abs(board[row]-board[prev]) == row-prev){
                return false;
            }
        }
        return true;
    }
}