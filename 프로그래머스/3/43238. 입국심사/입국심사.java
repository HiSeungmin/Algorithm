import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long start = 0;
        long end = (long) n * times[times.length - 1];
        long sum, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            sum = 0;
            for (int i = 0; i < times.length; i++)
                sum += mid / times[i];
            if (n > sum){ 
                start = mid + 1;
            }
            else{ 
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}