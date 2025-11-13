class Solution {
    public int solution(int n) {
        int answer = 1;
        int start = 1, end = 1, K=1;
        while(start <= end && end<n){
            if(K == n){
                answer += 1;
                end += 1;
                K += end;
            }else if(K < n){
                end += 1;
                K += end;
            }else{
                K -= start;
                start += 1;
            }
        }

        return answer;
    }
}