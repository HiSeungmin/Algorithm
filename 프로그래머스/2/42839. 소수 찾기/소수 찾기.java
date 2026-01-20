import java.util.*;
class Solution {
    public static int solution(String numbers) {
        Set<Integer> numSet = new HashSet<>();

        permutation("", numbers, numSet);

        int cnt = 0;
        for(int num:numSet){
            if(isPrime(num)){
                cnt ++;
            }
        }

        return cnt;
    }

    private static void permutation(String prefix, String str, Set<Integer> numSet){
        int n = str.length();

        if(!prefix.equals("")){
            numSet.add(Integer.parseInt(prefix));
        }

        for(int i=0; i<n; i++){
            permutation(prefix+str.charAt(i), str.substring(0, i)+
                    str.substring(i+1, n), numSet);
        }
    }

    private static boolean isPrime(int num){
        if(num<=1) return false;
        for(int i=2; i*i<=num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int output1 = solution("17");
        int output2 = solution("011");

        System.out.println(output1);
        System.out.println(output2);

    }
}