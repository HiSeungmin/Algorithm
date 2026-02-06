class Solution {
    public static long solution(int W, int H) {
        long answer;

        long w = (long)W;
        long h = (long)H;

        answer = (w*h) - ((w+h) - gcd(w, h));
        return answer;

    }

    private static long gcd(long w, long h){
        if(h == 0){
            return w;
        }
        return gcd(h, w%h);
    }
}