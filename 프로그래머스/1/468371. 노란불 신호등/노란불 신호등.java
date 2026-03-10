class Solution {
    public int solution(int[][] signals) {
        for (int t = 1; t <= 5000000; t++) {

            boolean allYellow = true;

            for (int[] s : signals) {

                int g = s[0];
                int y = s[1];
                int r = s[2];

                int cycle = g + y + r;
                int mod = t % cycle;

                if (!(mod >= g && mod < g + y)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) return t+1;
        }

        return -1;
    }
}