class Solution {
    public int solution(int[][] signals) {
        for(int t=1; t<5000000; t++){
            boolean isYellow = true;
            
            for(int[] s : signals){
                int g = s[0];
                int y = s[1];
                int r = s[2];
                
                int cycle = g+y+r;
                int mod = t%cycle;
                
                if(!(mod>g && mod <= g+y)){
                    isYellow = false;
                    break;
                }
            }
            
            if(isYellow) return t;
        }
        return -1;
    }
}