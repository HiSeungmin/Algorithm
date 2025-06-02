class Solution {
     public double solution(int[] array) {
        double answer=0;

        for(int i=0; i<array.length; i++){
            answer += array[i];
        }

        answer /= array.length;

        return answer;
    }
}