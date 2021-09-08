public class compress {
    public static void main(String[] args) {
        var result = new Solution();
        System.out.println(result.solution("a"));
    }
}

class Solution {
    public int solution(String s) {
        int answer = s.length();
        int curans = s.length();

        int curCharCnt = 1;
        String preChar = "";
        for (int degree = 1; degree <= s.length() / 2; degree++) {
            curans = s.length();
            preChar = s.substring(0, degree);
            int step = degree;
            for (; step <= s.length() - degree; step += degree) {
                String curChar = s.substring(step, step + degree);
                if (curChar.equals(preChar))
                    curCharCnt++;
                else {
                    if (curCharCnt != 1)
                        curans -= degree * (curCharCnt - 1) - Integer.toString(curCharCnt).length();

                    curCharCnt = 1;
                    preChar = curChar;
                }
            }

            if (curCharCnt != 1)
                curans -= degree * (curCharCnt - 1) - Integer.toString(curCharCnt).length();

            curCharCnt = 1;

            if (curans < answer)
                answer = curans;
        }
        return answer;
    }
}