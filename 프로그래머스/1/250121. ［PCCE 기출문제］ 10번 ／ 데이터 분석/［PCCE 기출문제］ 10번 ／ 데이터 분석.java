import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int x = standard(ext);
        int y = standard(sort_by);

        List<int[]> list = new ArrayList<>();

        for (int[] row : data) {
            if (row[x] <= val_ext) {
                list.add(row);
            }
        }

        list.sort(Comparator.comparingInt(row -> row[y]));

        return list.toArray(new int[0][]);
    }

    public int standard(String str){
        int x;

        if(str.equals("code")){
            x=0;
        }else if(str.equals("date")){
            x=1;
        }else if(str.equals("maximum")){
            x=2;
        }else {
            x=3;
        }

        return x;
    }
}