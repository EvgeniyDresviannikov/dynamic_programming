package longest.palindromic.subsequence;

public class CountOfPalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countPalindromicSubstring("aaa"));
    }

    public static Integer countPalindromicSubstring (String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd palindroms
            int left = i;
            int right = i;
            while (left > -1 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }

            // even palindroms
            left = i;
            right = i+1;
            while (left > -1 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    res++;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
