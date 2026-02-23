class Solution {
    public static int solution(int n, int w, int num) {
        int cnt = 1;
        int h, idx;

        h = (num%w)!=0? (num/w)+1 : num/w;
        idx = h%2 == 0? (w*h) - num + 1 : w - ((w*h)-num);

        for(int i=h+1; i<=(n/w) + 1; i++){

            if(i % 2 == 0){
                if ((w*i) - idx + 1 <= n){
                    cnt += 1;
                }
            }else{
                if ((w*i) - (w-idx) <= n){
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}