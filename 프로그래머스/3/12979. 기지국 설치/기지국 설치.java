class Solution {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int ran = (w*2)+1;
        int s = 0;

        for(int i:stations){
            int e = i-w-1;

            if(e>0){
                if((e-s)%ran>0){
                    answer += 1;
                }
                 answer += (e-s)/ran;
            }

            s = i+w;
        }
        if(s<n){
            if((n-s)%ran>0){
                answer += 1;
            }
            answer += (n-s)/ran;
        }

        return answer;
    }
}