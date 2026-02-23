import java.util.*;
class Solution {
    private static int one_cnt;
    private static int zer_cnt;

    public static int[] solution(int[][] arr) {

        separate(0, 0, arr.length, arr);

        return new int[]{zer_cnt, one_cnt};
    }

    private static void separate(int x, int y, int n, int[][] arr){
    
        int num = check_num(x, y, n, arr);

        if( num != -1 ){
            if(num == 0) zer_cnt += 1;
            else if(num == 1) one_cnt += 1;
            return;
        }

        if(n>=2){
            separate(x, y, n/2, arr);
            separate(x, y + (n/2), n/2, arr);
            separate(x + (n/2), y, n/2, arr);
            separate(x + (n/2), y + (n/2), n/2, arr);

        }
    }
    private static int check_num(int x, int y, int n, int[][] arr){

        int num = arr[x][y];
        for(int i=x; i< x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[i][j] != num){
                    return -1;
                }
            }
        }

        return arr[x][y];
    }
}