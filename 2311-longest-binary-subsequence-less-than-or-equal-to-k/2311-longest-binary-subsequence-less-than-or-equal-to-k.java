class Solution {
    
    public int longestSubsequence(String s, int k) {
        String t = Integer.toBinaryString(k);
        int slen = s.length();
        int tlen = t.length();
        
        for (int size = tlen; size >= 0; size--) {
            // Find the deterministic suffix of the longest sequence.
            for (int i = slen - size, j = slen - 1; i >= 0; i--,j--) {
			    String suffix = s.substring(i, j + 1);
                int suffixValue = Integer.parseInt(suffix, 2);
                if (suffixValue <= k) {
                    int zeros = countZeros(s, 0, i);
                    return zeros + j - i + 1;
                }
            }
        }
        return 0;
    }
    
    // Count zeros in str[s:e)
    private int countZeros(String str, int s, int e) {
        int count = 0;
        for (int i = s; i < e; i++)
            if (str.charAt(i) == '0')
                count++;
        return count;
    }
}