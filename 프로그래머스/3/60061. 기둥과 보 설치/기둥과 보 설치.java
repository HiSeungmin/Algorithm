import java.util.*;
class Solution {
    public static boolean check(ArrayList<int[]> array){

        for(int[] arr : array){
            int x = arr[0];
            int y = arr[1];
            int a = arr[2];

            if(arr[2] == 0){ //기둥일 때
                // 바닥인지, 기둥 위인지, 보 위인지
                if(y != 0 &&
                !contains(array, new int[]{x, y-1, 0}) &&
                !contains(array, new int[]{x-1, y, 1}) &&
                !contains(array, new int[]{x, y, 1})) {
                    return false;
                }
            }else if(arr[2] == 1){ //보 일 때
                // 기둥 위인지(2), 양 옆이 보인지
                if (!contains(array, new int[]{x, y - 1, 0}) &&
                    !contains(array, new int[]{x + 1, y - 1, 0}) &&
                    (!contains(array, new int[]{x - 1, y, 1}) ||
                    !contains(array, new int[]{x + 1, y, 1}))) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean contains(List<int[]> list, int[] target) {
        for (int[] arr : list) {
            if (Arrays.equals(arr, target)) {
                return true;
            }
        }
        return false;
    }

    public static int[][] solution(int n, int[][] build_frame) {
        ArrayList<int[]> answer = new ArrayList();

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];
            int b = frame[3];

            int[] arr = new int[]{x, y, a};

            if (b == 1) { // 설치
                answer.add(arr);
                if (!check(answer)) {
                    answer.remove(answer.size() - 1);
                }
            } else { // 삭제
                answer.removeIf(e -> Arrays.equals(e, arr));
                if (!check(answer)) {
                    answer.add(arr); // 원상복구
                }
            }
        }

        answer.sort((o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[2] - o2[2];
        });

        return answer.toArray(new int[answer.size()][]);
    }
}