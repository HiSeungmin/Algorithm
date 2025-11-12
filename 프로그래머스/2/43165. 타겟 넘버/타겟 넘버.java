class Solution {
    static int N;
    static int T;
    static int[] Numbers;
    static int total;
    public static int solution(int[] numbers, int target) {
        total = 0;
        N = numbers.length;
        T = target;
        Numbers = numbers;

        dfs(0,0);

        return total;
    }

    public static void dfs(int idx, int s){
        if(idx == N){
            if(s == T){
                total += 1;
                return ;
            }
            return ;
        }
        dfs(idx+1, s+Numbers[idx]);
        dfs(idx+1, s-Numbers[idx]);
    }
}