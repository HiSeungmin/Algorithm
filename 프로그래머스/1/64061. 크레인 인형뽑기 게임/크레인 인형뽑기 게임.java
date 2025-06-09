import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int x = board.length;
        int y = board[0].length;

        Stack<Integer>[] st = new Stack[x];
        for(int k=0; k<y; k++){
            st[k] = new Stack<>();
        }

        for(int i=x-1; i>-1; i--){
            for(int j=0; j<y; j++){
                if (board[i][j]>0)
                    st[j].push(board[i][j]);
            }
        }

        Stack<Integer> basket = new Stack<>();

        for(int i:moves){
            if(!st[i-1].isEmpty()){
                int doll = st[i-1].pop();
                if(!basket.isEmpty() && basket.peek() == doll){
                    basket.pop();
                    answer += 2;
                }else{
                    basket.push(doll);
                }
            }
        }

        return answer;
    }
}