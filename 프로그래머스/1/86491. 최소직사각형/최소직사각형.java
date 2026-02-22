class Solution {
    public static int solution(int[][] sizes) {
        int max_w = 0;
        int max_h = 0;

        for(int[] size: sizes){
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);

            max_w = Math.max(w, max_w);
            max_h = Math.max(h, max_h);
        }

        return (max_w * max_h);
    }
}