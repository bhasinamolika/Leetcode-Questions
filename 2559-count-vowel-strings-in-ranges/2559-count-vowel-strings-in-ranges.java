class Solution {
    private boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            return true;
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int ans[]=new int[queries.length];
        int pref[]=new int[words.length];
        if(isVowel(words[0].charAt(0)))
            pref[0]=1;
        for(int i=1;i<pref.length;i++){
            if(isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length()-1))){
                pref[i]=pref[i-1]+1;
            }
            else
                pref[i]=pref[i-1];
        }
        //System.out.println(Arrays.toString(pref));
        for(int i=0;i<queries.length;i++){
            ans[i]=pref[queries[i][1]]-pref[queries[i][0]];
            if(isVowel(words[queries[i][0]].charAt(0)) && isVowel(words[queries[i][0]].charAt(words[queries[i][0]].length()-1)))
                ans[i]++;
        }
        return ans;
    }
}