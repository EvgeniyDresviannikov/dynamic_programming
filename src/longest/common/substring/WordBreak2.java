package longest.common.substring;

import java.util.ArrayList;
import java.util.List;

public class WordBreak2 {

    static List<String> result;
    static List<String> dict;
    static String str;

    public static void main(String[] args) {
        System.out.println(wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple")));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        dict = wordDict;
        str = s;

        dfs("", s);

        return result;
    }

    private static void dfs(String currentCombination, String rest) {
        if (rest.isEmpty()) {
            result.add(currentCombination.trim());
            return;
        }

        for (int i = 0; i < dict.size(); i++) {
            String w = dict.get(i);
            if (rest.startsWith(w)) {
                dfs(currentCombination + " " + w, rest.substring(w.length()));
            }
        }
    }
}
