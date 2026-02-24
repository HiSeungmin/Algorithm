import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        File[] fileList = new File[files.length];

        for(int i=0; i<files.length; i++){
            String[] tmp = new String[2];
            int start=0, end;
            for(int j=0; j<2; j++){
                end = split(start, files[i]);
                tmp[j] = files[i].substring(start, end);
                start = end;
            }
            fileList[i] = new File(i, tmp[0], tmp[1], files[i]);
        }
        
        Arrays.sort(fileList, (o1, o2) -> {
            if(!o1.head.equals(o2.head)){
                return o1.head.compareTo(o2.head);
            }else if(o1.number != o2.number){
                return o1.number - o2.number;
            }else{
                return o1.idx - o2.idx;
            }
        });
        
        String[] answer = new String[files.length];
        int i=0;
        for(File f:fileList){
            answer[i++] = f.fileName;
        }
        return answer;
    }

    public static int split(int i, String fileName){
        boolean isNum = fileName.charAt(i)>='0' && fileName.charAt(i)<='9';
        for(; i<fileName.length(); i++){
            if(isNum != fileName.charAt(i)>='0' && fileName.charAt(i)<='9'){
                break;
            }
        }
        return i;
    }

    class File{
        int idx;
        String head;
        int number;
        String fileName;

        File(int idx, String head, String number, String fileName) {
            this.idx = idx;
            this.head = head.toUpperCase();
            this.number = Integer.parseInt(number);
            this.fileName = fileName;
        }
    }
}