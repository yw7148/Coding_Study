public class dart {
    public static void main(String[] args) {
        var input = "1S*2T*3S";
        var result = new Solution2();
        System.out.println(result.solution(input));
    }
}

class Solution2 {
    public int solution(String dartResult) {
        int answer = 0;
        int now = 0;
        int pre = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char cur = dartResult.charAt(i);

            if (cur <= 57 && cur > 47) {
                pre = now;
                now = cur - 48;
                if (cur == '1' && dartResult.charAt(i + 1) == '0') {
                    now = 10;
                    i++;
                }
            } else if (cur == 'S')
                answer += now;
            else if (cur == 'D') {
                now *= now;
                answer += now;
            } else if (cur == 'T') {
                now *= now * now;
                answer += now;
            } else if (cur == '*') {
                answer += now + pre;
                now = now + now;
            } else if (cur == '#') {
                answer -= now * 2;
                now = -now;
            }

        }
        return answer;
    }
}