public class sharpmap {
    public static void main(String[] args) {
        var input = new int[] { 9, 20, 28, 18, 11 };
        var input2 = new int[] { 30, 1, 21, 17, 28 };
        var n = 5;
        var result = new Solution();
        var res = result.solution(n, input, input2);
        for (String string : res) {
            System.out.println(string);
        }

    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String ans = "";
            for (int j = n; j > 0; j--) {
                int res1 = arr1[i] % 2;
                int res2 = arr2[i] % 2;
                if (res1 == 0 && res2 == 0)
                    ans = " " + ans;
                else
                    ans = "#" + ans;

                arr1[i] /= 2;
                arr2[i] /= 2;
            }
            answer[i] = ans;
        }
        return answer;
    }
}