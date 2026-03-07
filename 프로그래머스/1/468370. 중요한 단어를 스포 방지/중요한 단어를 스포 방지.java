import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        int[] charToWord = new int[n];

        List<String> words = new ArrayList<>();
        List<int[]> wordRanges = new ArrayList<>();

        int start = 0;
        int wordIdx = 0;

        for (int i = 0; i <= n; i++) {
            if (i == n || message.charAt(i) == ' ') {
                words.add(message.substring(start, i));
                wordRanges.add(new int[]{start, i - 1});

                for (int j = start; j < i; j++) {
                    charToWord[j] = wordIdx;
                }

                wordIdx++;
                start = i + 1;
            }
        }

        int w = words.size();

        boolean[] wordInSpoiler = new boolean[w];

        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                if (message.charAt(i) != ' ') {
                    wordInSpoiler[charToWord[i]] = true;
                }
            }
        }

        Set<String> normalWords = new HashSet<>();

        for (int i = 0; i < w; i++) {
            if (!wordInSpoiler[i]) {
                normalWords.add(words.get(i));
            }
        }

        Set<String> revealed = new HashSet<>();
        boolean[] revealedChar = new boolean[n];

        int answer = 0;

        for (int[] range : spoiler_ranges) {
            Set<Integer> currentWords = new HashSet<>();

            for (int i = range[0]; i <= range[1]; i++) {
                if (message.charAt(i) != ' ') {
                    int wi = charToWord[i];
                    currentWords.add(wi);
                }
            }

            for (int wi : currentWords) {
                String word = words.get(wi);

                if (!normalWords.contains(word) && !revealed.contains(word)) {
                    answer++;
                    revealed.add(word);
                }
            }
        }

        return answer;
    }
}