class Solution {
    public int minDeletions(String s) {
         // Store the frequency of each character
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        int delCount=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<26;i++){
            
                while(frequency[i]!=0 && set.contains(frequency[i])){
                    frequency[i]--;
                    delCount++;
                }
                set.add(frequency[i]);
            }
        
        return delCount;
    }
}