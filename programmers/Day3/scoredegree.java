public class scoredegree {
    public static void main(String[] args) {
        var input = new int[][] { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 },
                { 61, 57, 100, 80, 65 }, { 24, 90, 94, 75, 65 } };
        var result = new Solution();
        System.out.println(result.solution(input));
    }
}

class Solution {
    public String solution(int[][] scores) {
        String answer = "";

        for (int i = 0; i < scores.length; i++) {
            int self = scores[i][i];
            boolean selfhigh = true;
            boolean selflow = true;

            int avg = 0;
            for (int j = 0; j < scores.length; j++) {
                int other = scores[j][i];
                avg += scores[j][i];

                if (i == j)
                    continue;

                if (self <= other)
                    selfhigh = false;
                if (self >= other)
                    selflow = false;
            }

            if (selfhigh || selflow) {
                avg -= self;
                avg = avg / (scores.length - 1);
            } else {
                avg = avg / scores.length;
            }

            if (avg >= 90)
                answer += "A";
            else if (avg >= 80)
                answer += "B";
            else if (avg >= 70)
                answer += "C";
            else if (avg >= 50)
                answer += "D";
            else
                answer += "F";
        }
        return answer;
    }
}