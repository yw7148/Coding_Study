import java.util.*;

public class progress {
    public static void main(String[] args) {
        var input = new int[] { 95, 90, 99, 99, 80, 99 };
        var input2 = new int[] { 1, 1, 1, 1, 1, 1 };
        var result = new Solution();
        var res = result.solution(input, input2);
        for (int i : res) {
            System.out.println(i);
        }

    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerL = new ArrayList<>();
        int date = -1;
        int curProEnd;
        int pros = 0;
        for (int i = 0; i < progresses.length; i++) {
            curProEnd = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0)
                curProEnd++;

            if (date < curProEnd) {
                if (pros > 0) {
                    answerL.add(pros);
                    pros = 0;
                }

                pros++;
                date = curProEnd;
            } else {
                pros++;
            }
        }
        answerL.add(pros);
        int[] answer = new int[answerL.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerL.get(i).intValue();
        }
        return answer;
    }
}