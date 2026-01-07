class Solution {
    public static long solution(int a, int b) {
        long answer = 0;

        if(a==b){
            return a;
        }

        long sum = 0;

        if(a<b){
            for(;a<=b;a++){
                sum += a;
            }
        }else if(a>b){
            for(;a>=b;a--){
                sum += a;
            }
        }

        return sum;
    }
}