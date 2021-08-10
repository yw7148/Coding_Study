public class leftright {
    public static void main(String[] args) {
        var result = new Solution2();
        System.out.println(result.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }, "right"));
    }
}

class Solution2 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int lpos = 10;
        int rpos = 12;
        for (int i = 0; i < numbers.length; i++) {
            int curnum = numbers[i];
            if (curnum == 0)
                curnum = 11;
            if (curnum == 1 || curnum == 4 || curnum == 7) {
                lpos = curnum;
                answer += "L";
            } else if (curnum == 3 || curnum == 6 || curnum == 9) {
                rpos = curnum;
                answer += "R";
            } else {
                int curY = (curnum - 1) / 3;
                int lposY = (lpos - 1) / 3;
                int rposY = (rpos - 1) / 3;

                int curX = 1;
                int lposX = (lpos - 1) % 3;
                int rposX = (rpos - 1) % 3;

                int ldistanceY = lposY - curY;
                int ldistanceX = curX - lposX;
                int rdistanceY = rposY - curY;
                int rdistanceX = rposX - curX;
                if (ldistanceY < 0)
                    ldistanceY *= -1;
                if (rdistanceY < 0)
                    rdistanceY *= -1;

                int ldistance = ldistanceX + ldistanceY;
                int rdistance = rdistanceX + rdistanceY;

                if (ldistance < rdistance) {
                    lpos = curnum;
                    answer += "L";
                } else if (rdistance < ldistance) {
                    rpos = curnum;
                    answer += "R";
                } else {
                    if (hand.equals("right")) {
                        rpos = curnum;
                        answer += "R";
                    } else if (hand.equals("left")) {
                        lpos = curnum;
                        answer += "L";
                    }
                }

            }
        }

        return answer;
    }
}