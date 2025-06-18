class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'P' || s.charAt(i) == 'p'){
                pCnt += 1;
            }else if(s.charAt(i) == 'Y' || s.charAt(i) == 'y'){
                yCnt += 1;
            }
        }
        
        if(pCnt == yCnt){
            return true;
        }else{
            return false;
        }
    }
}