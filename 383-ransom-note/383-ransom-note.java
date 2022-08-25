class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> magMap=new HashMap<>();
        for(char c:magazine.toCharArray()){
            magMap.put(c,magMap.getOrDefault(c,0)+1);
        }
        for(int i=0;i<ransomNote.length();i++){
            if(!magMap.containsKey(ransomNote.charAt(i)))
                return false;
            else{
                if(magMap.get(ransomNote.charAt(i))>1){
                    magMap.put(ransomNote.charAt(i),magMap.get(ransomNote.charAt(i))-1);
                }
                else if(magMap.get(ransomNote.charAt(i))==1){
                    magMap.remove(ransomNote.charAt(i));
                }
            }
        }
        return true;
    }
}