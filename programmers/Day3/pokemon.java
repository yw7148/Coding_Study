public class pokemon {
    public static void main(String[] args) {
        var input = new int[] { 3, 1, 2, 3 };
        var result = new Solution2();
        System.out.println(result.solution(input));
    }
}

class Solution2 {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1)
                continue;
            else
                answer++;

            if (answer == nums.length / 2)
                return answer;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    nums[j] = -1;
                }
            }
        }
        return answer;
    }
}