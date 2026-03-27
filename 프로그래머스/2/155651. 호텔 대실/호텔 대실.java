import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        int N = book_time.length;
        Book[] list = new Book[N];
        ArrayList<Integer> room = new ArrayList<>();

        for(int i=0; i<N; i++){
            String[] time = book_time[i];
            Book newBook = new Book(time[0], time[1]);
            list[i] = newBook;
        }

        Arrays.sort(list, (a, b)-> a.start - b.start);
        room.add(0);

        for(int i=0; i<N; i++){
            Book b = list[i];

            int j=0;
            boolean flag = true;
            while(j<room.size() && flag){
                if(room.get(j) <= b.start){
                    room.set(j, b.end);
                    flag = false;
                }
                j++;
            }
            if(flag){
                room.add(b.end);
            }
        }

        return room.size();
    }

    class Book {
        int start = 0;
        int end = 0;

        Book(String start, String end){
            String[] s = start.split(":");
            this.start = Integer.parseInt(s[0])*60;
            this.start += Integer.parseInt(s[1]);

            String[] e = end.split(":");
            this.end = Integer.parseInt(e[0])*60;
            this.end += Integer.parseInt(e[1]);
            this.end += 10;
        }
    }
}