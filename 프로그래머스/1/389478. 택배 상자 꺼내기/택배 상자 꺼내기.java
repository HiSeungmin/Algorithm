class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0; 
        int row = (num-1)/w; 
        int col = w-1; 
        int pin = 0; 

        if (row%2 == 0) { 
            pin = (num-1) % w;
        } else { 
            pin = col - (num-1) % w;
        }

        for (; row < (n+col)/w; row++) { 
            int aboveBox = 0; 
            if (row % 2 == 0) { 
                aboveBox = pin + (row * w);
            } else { 
                aboveBox = (col - pin) + (row * w);
            }
            if (aboveBox < n) {
                answer++;
            }
        }
        return answer;
    }
}