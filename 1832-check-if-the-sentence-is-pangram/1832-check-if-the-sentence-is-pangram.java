class Solution {
    public boolean checkIfPangram(String sentence) {
        int characters[]=new int[26];
        boolean flag=true;
        for(char ch:sentence.toCharArray()){
            characters[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(characters[i]==0){
                flag=false;
                break;
            }
        }
        return flag;
    }
}