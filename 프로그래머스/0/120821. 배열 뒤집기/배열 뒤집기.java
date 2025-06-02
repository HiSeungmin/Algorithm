class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[array.length];
        int idx = 0;
        for(int i = array.length-1; i>-1; i--){
            answer[idx++] = array[i];
        }
        return answer;
    }
}