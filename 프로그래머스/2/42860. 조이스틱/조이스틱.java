class Solution {
    public static int solution(String name) {
        int answer = 0;
        int n = name.length();
        int min_move = n - 1;

        for(int i=0; i<n; i++){
            char c = name.charAt(i);
            answer += Math.min(c-'A','Z'-c+1);

            int next = i+1;
            while(next<n && name.charAt(next) == 'A'){
                next += 1;
            }

            min_move = Math.min(min_move, Math.min(2*i+n-next, i+2*(n-next)));
        }

        answer += min_move;
        return answer;
    }
}