class Solution {
    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = (w*2)+1;
        int s = 0;
        for(int i: stations){
            int e = i-w-1;

            if(e>0){
                answer += (e-s)%range>0? ((e-s)/range)+1:((e-s)/range);
            }
            s = i+w;
        }
        if(s<n){
            answer += (n-s)%range>0? ((n-s)/range)+1:((n-s)/range);
        }
        return answer;
    }
}