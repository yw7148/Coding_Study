public class print {
    public static void main(String[] args) {
        var input = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        var input2 = 3;
        var result = new Solution2();
        System.out.println(result.solution(input, input2));
    }
}

class Solution2 {

    public int solution(int[] priorities, int location) {
        int answer = 1;
        int high = 0;
        int lasthigh = 10;
        int lastloc = 0;
        int cnt = 0;
        int answerCnt = 0;
        while (true) {
            int end = lastloc - 1;
            if (lastloc == 0)
                end = priorities.length - 1;
            for (int i = lastloc;; i = (i + 1) % priorities.length) {
                if (priorities[i] >= lasthigh)
                    continue;

                if (i == location) {
                    if (high < priorities[i])
                        answerCnt = 0;
                    else
                        answerCnt = cnt;
                }

                if (priorities[i] > high) {
                    high = priorities[i];
                    lastloc = i;
                    cnt = 1;
                } else if (priorities[i] == high) {
                    cnt++;
                    lastloc = i;
                }

                if (i == end)
                    break;
            }

            if (high == priorities[location]) {
                answer += answerCnt;
                break;
            }

            answer += cnt;
            lasthigh = high;
            high = 0;
            cnt = 0;
        }

        return answer;
    }
}