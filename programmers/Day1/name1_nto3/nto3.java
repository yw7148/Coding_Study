public class nto3 {
    public static void main(String[] args) {
        var result = new Solution();
        System.out.println(result.solution(125));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        var nto3 = this.Nto3(n);
        for (int i = 0; i < nto3.length; i++) {
            int pos = 1;
            for (int j = 1; j <= i; j++) {
                pos *= 3;
            }
            answer = answer + nto3[nto3.length - i - 1] * pos;
        }
        return answer;
    }

    public int[] Nto3(int n) {
        int[] result = new int[n];
        int cnt = 0;
        while (n > 0) {
            result[cnt] = n % 3;
            n = n / 3;
            cnt++;
        }

        int[] returnV = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            returnV[i] = result[i];
        }
        return returnV;
    }
}
