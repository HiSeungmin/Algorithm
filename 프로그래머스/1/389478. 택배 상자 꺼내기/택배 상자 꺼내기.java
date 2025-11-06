class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int col = (num-1)/w; 
        int row = w-1; 
        
        if(col%2==0){
            row = (num-1)%w;
        }else{
            row = w-1 - (num-1)%w;
        }
        
        for(int i=num; i<=n; i++){
            int max_col = (i-1)/w;
            if(max_col%2==0 && row==(i-1)%w){
                answer++;
            }else if(max_col%2!=0 && row==(w-1 - (i-1)%w)){
                answer++;
            }
        }
        return answer;
    }
}