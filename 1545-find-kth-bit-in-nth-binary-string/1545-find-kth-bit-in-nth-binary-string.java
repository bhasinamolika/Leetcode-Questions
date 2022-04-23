class Solution {
    public char findKthBit(int n, int k) {
        return rec(n).charAt(k-1);
    }
    
	
    public String rec(int n) {
        if (n == 1){ 
            return "0";
        } else {
            String s = rec(n-1);
            return s + "1" + reverse_and_invert(s);
        }
    }
    
	
    public String reverse_and_invert(String s) {
       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.reverse().toString();
    }
    
}