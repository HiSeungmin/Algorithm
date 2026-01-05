import java.util.*;
class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int l : lost) lostSet.add(l);
        for (int r : reserve) reserveSet.add(r);

        Set<Integer> both = new HashSet<>(lostSet);
        both.retainAll(reserveSet);

        lostSet.removeAll(both);
        reserveSet.removeAll(both);

        for (int l : lostSet) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
            } else {
                n--;
            }
        }

        return n;
    }
}