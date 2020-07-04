public class LcsRecursive {

    /**
     * Returns the longest subsequence of two sequence using the recursion method
     *
     * @param s1 String of sequence
     * @param s2 String of sequence
     * @return String of longest subsequence
     */
    public String compute(String s1, String s2){
        int s1Size = s1.length();
        int s2Size = s2.length();

        if (s1Size == 0 || s2Size == 0) {
            return "";
        } else if (s1.charAt(s1Size - 1) == s2.charAt(s2Size - 1)){
            return compute(s1.substring(0, s1Size - 1), s2.substring(0, s2Size - 1)) + s1.charAt(s1Size - 1);
        } else {
            String s1Max = compute(s1, s2.substring(0, s2Size - 1));
            String s2Max = compute(s1.substring(0, s1Size - 1), s2);

            return s1Max.length() > s2Max.length() ? s1Max : s2Max;
        }
    }
}
