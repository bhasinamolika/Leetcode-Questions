class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Set<String> st1 = new HashSet<>();
        Set<String> st2 = new HashSet<>();
        for(String word : words){
            if(st1.contains(word)){
                count++;
            }else if(st2.contains(word)){}
            else{
                if(isSubsequence(word, s)){
                    st1.add(word);
                    count++;
                }else{
                    st2.add(word);
                }
            }
        }
        return count;
    }
    
    public boolean isSubsequence(String word, String s){
        int n = s.length();
        int m = word.length();
        int k = 0;
        for(int i= 0; i < n && k < m; i++){
            if(s.charAt(i) == word.charAt(k)){
                k++;
            }
        }
        if(k == m)
            return true;
        return false;
    }
}