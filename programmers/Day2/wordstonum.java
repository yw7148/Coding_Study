public class wordstonum {
    public static void main(String[] args) {
        var result = new Solution();
        System.out.println(result.solution("23four5six7"));
    }
}

class Solution {
    public int solution(String s) {
        int answer = 0;
        String answerS = "";
        int step = 0;
        while (step < s.length()) {
            if (s.charAt(step) <= 57 && s.charAt(step) >= 48) {
                answerS += s.charAt(step);
                step++;
            } else {
                String[] words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

                int endnum = step + 5;
                if (endnum > s.length())
                    endnum = s.length();

                String sub5 = s.substring(step, endnum);
                for (int i = 0; i < words.length; i++) {
                    if (sub5.contains(words[i])) {
                        answerS += i;
                        step += words[i].length();
                        break;
                    }
                }
            }

        }
        answer = Integer.parseInt(answerS);
        return answer;
    }
}