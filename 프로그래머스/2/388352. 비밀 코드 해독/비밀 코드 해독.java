class Solution {
    private static int N;
    private static int[] selected = new int[5];
    private static int answer;
    private static int[][] Q;
    private static int[] Ans;

    public static int solution(int n, int[][] q, int[] ans) {
        N = n;
        Q = q;
        Ans = ans;
        answer = 0;

        dfs(1, 0);

        return answer;
    }

    static void dfs(int start, int depth) {
        if (depth == 5) {
            isValid(selected);
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    static void isValid(int[] arr) {
        for (int i = 0; i < Ans.length; i++) {
            int[] qq = Q[i];
            int expected = Ans[i];
            int cnt = 0;
            
            for (int k : qq) {
                for (int v : arr) {
                    if (k == v) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt != expected) {
                return;
            }
        }
        answer++;
    }
}