import java.util.*;

class Solution {
    public Integer[] solution(int N, int[] stages) {
        int[] answer = new int[N+1];
        double[] arr = new double[N+1];
        int peop = stages.length;

        for(int i = 0; i<stages.length; i++) {
            if(stages[i] < N+1)
                answer[stages[i]] += 1;
        }

        for(int i = 1; i<N+1; i++){
            arr[i] = answer[i]==0?0:(double)answer[i]/peop;
            peop -= answer[i];
        }

        Integer[] index = new Integer[N];
        for (int i = 0; i < N; i++) {
            index[i] = i+1;
        }

        Arrays.sort(index, (a, b) -> {
            if (arr[b] != arr[a]) {
                return Double.compare(arr[b], arr[a]);
            } else {
                return Integer.compare(a, b);
            }
        });
        return index;
    }
}