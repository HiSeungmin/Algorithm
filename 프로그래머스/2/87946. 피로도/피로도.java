class Solution {
    static int len;
    static int answer;
    private static void BT(int cnt, int damage, int[] visited, int[][] dungeons) {
        answer = Math.max(answer, cnt);

        if(damage<=0|| cnt>len){
            return;
        }

        for(int i = 0; i<len; i++){
            if(visited[i]==0){
                if(damage>=dungeons[i][0] && damage-dungeons[i][1]>0){
                    visited[i] = 1;
                    BT(cnt+1, damage-dungeons[i][1], visited, dungeons);
                    visited[i] = 0;
                }
            }
        }
    }

    public static int solution(int k, int[][] dungeons) {
        answer = -1;
        len = dungeons.length;
        int[] visited = new int[len];
        BT(0, k, visited, dungeons);
        return answer;
    }
}