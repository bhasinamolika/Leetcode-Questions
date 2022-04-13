class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans=new StringBuilder("");
        int pointer=0;
        for(int i=0;i<s.length();i++){
            if(pointer<spaces.length && i==spaces[pointer]){
                ans.append(" "+s.charAt(i));
                pointer++;
            }
            else
                ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}