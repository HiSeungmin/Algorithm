class Solution {
    public static int solution(int[][] land) {
        int answer;
        int N = land.length;
        int[][] nland = new int[N][4];
        nland[0][0] = land[0][0];
        nland[0][1] = land[0][1];
        nland[0][2] = land[0][2];
        nland[0][3] = land[0][3];


        for(int i=1; i<N; i++){
            for(int j=0; j<4; j++){
                int[] pValue = findIntArray(nland, i-1, j);
                nland[i][j] = Math.max(pValue[0], Math.max(pValue[1], pValue[2]))+land[i][j];
            }
        }

        answer = Math.max(Math.max(nland[N-1][0], nland[N-1][1]),Math.max(nland[N-1][2], nland[N-1][3]));
        return answer;
    }

    private static int[] findIntArray(int[][] nland, int row, int sameColIdx){
        int[] newArray = new int[3];
        int k = 0;
        for(int num=0; num<4; num++){
            if(num==sameColIdx) continue;
            newArray[k++] = nland[row][num];
        }
        return newArray;
    }
}