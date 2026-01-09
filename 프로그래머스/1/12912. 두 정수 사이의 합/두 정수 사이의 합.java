class Solution {
    public static long solution(int a, int b) {
        long answer = 0;
        int sNum = (a<b)?a:b;
        int bNum = (a<b)?b:a;
        for(;sNum<=bNum;sNum++){
            answer += sNum;
        }
    
        return answer;
    }
}