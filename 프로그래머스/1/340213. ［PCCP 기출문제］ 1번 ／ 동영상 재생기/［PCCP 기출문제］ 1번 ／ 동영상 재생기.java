class Solution {
    private static int op_s;
    private static int op_e;

    private static int changeToSeconds(String time){
        int answer = 0;
        String[] tArr = time.split(":");
        answer += Integer.parseInt(tArr[0])*60;
        answer += Integer.parseInt(tArr[1]);
        return answer;
    }

    private static boolean opCheck(int time){
        if(op_s<=time && time<=op_e){
            return true;
        }
        return false;
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int vLen = changeToSeconds(video_len);
        int current = changeToSeconds(pos);
        op_s = changeToSeconds(op_start);
        op_e = changeToSeconds(op_end);
        current = opCheck(current)? op_e:current;

        for(String btn : commands){
            System.out.println(current);

            if(btn.equals("prev"))      { current -= 10; }
            else if(btn.equals("next")) { current += 10; }

            if(current<0){current = 0;}
            current = opCheck(current)? op_e:current;
            current = Math.min(vLen, current);
        }

        String minute = (current/60<10?"0"+(current/60):(current/60)+"");
        String second = (current%60<10?"0"+(current%60):(current%60)+"");

        answer = minute+":"+second;

        return answer;
    }
}