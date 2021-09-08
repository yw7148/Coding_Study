import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leftright {
    public static void main(String[] args) {
        var result = new Solution2();
        System.out.println(result.solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                "Enter uid1234 Prodo", "Change uid4567 Ryan" }));
    }
}

class Solution2 {
    public String[] solution(String[] record) {
        Map<String, String> idName = new HashMap<String, String>();
        List<String> idAnswer = new ArrayList<String>();
        List<String> answer = new ArrayList<String>();
        for (String sentence : record) {
            String[] word = sentence.split(" ");
            if (word[0].equals("Enter")) {
                idAnswer.add(word[1]);
                idAnswer.add("님이 들어왔습니다.");
                idName.put(word[1], word[2]);
            } else if (word[0].equals("Leave")) {
                idAnswer.add(word[1]);
                idAnswer.add("님이 나갔습니다.");
            } else if (word[0].equals("Change")) {
                idName.put(word[1], word[2]);
            }
        }

        for (int i = 0; i < idAnswer.size(); i += 2) {
            answer.add(idName.get(idAnswer.get(i)) + idAnswer.get(i + 1));
        }
        return answer.toArray(new String[0]);
    }
}