import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int N = wallpaper.length;
        int M = wallpaper[0].length();
        int startX = N, startY = M, endX = 0, endY = 0;

        
        for(int i=0; i<N; i++){
            String str = wallpaper[i];
            for(int j=0; j<M; j++){
                if(str.charAt(j) == '#'){
                    startX = Math.min(startX, i);
                    startY = Math.min(startY, j);
                    endX = Math.max(endX, i);
                    endY = Math.max(endY, j);
                }
            }
        }

        answer[0] = startX;
        answer[1] = startY;
        answer[2] = endX+1;
        answer[3] = endY+1;

        return answer;
    }
}