import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int maxMinerals = (picks[0] + picks[1] + picks[2]) * 5;
        int N = Math.min(minerals.length, maxMinerals);;
        int num = (N + 4) / 5;

        Group[] groupList = new Group[num];

        for(int i=0; i<num; i++){
            Group g = new Group();
            for(int j=0; j<5; j++){
                int idx = i*5+j;
                if(idx >= N) break;

                if(minerals[idx].equals("diamond")) g.increaseDia();
                else if(minerals[idx].equals("iron")) g.increaseIron();
                else if(minerals[idx].equals("stone")) g.increaseStone();
            }
            g.updateScore();
            groupList[i] = g;
        }

        Arrays.sort(groupList, (a,b) -> b.getScore() - a.getScore());

        for(int i=0; i<num; i++){
            if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0) break;
            
            Group group = groupList[i];

            if(picks[0] != 0){
                answer += (group.dia + group.iron + group.stone);
                picks[0] -= 1;
            }else if(picks[1] != 0){
                answer += (group.dia*5 + group.iron + group.stone);
                picks[1] -= 1;
            }else if(picks[2] != 0){
                answer += group.score;
                picks[2] -= 1;
            }
        }

        return answer;
    }

    class Group {
        int dia = 0;
        int iron = 0;
        int stone = 0;
        int score = 0;

        void increaseDia(){
            this.dia += 1;
        }

        void increaseIron(){
            this.iron += 1;
        }
        void increaseStone(){
            this.stone += 1;
        }

        void updateScore(){
            score = this.dia*25 + this.iron*5 + this.stone;
        }

        int getScore(){
            return this.score;
        }
    }
}