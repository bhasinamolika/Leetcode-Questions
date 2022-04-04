class Solution {
    public void reverseString(char[] s) {
        rev(s,0,s.length-1);
    }
    public void rev(char s[],int i,int j){
        if(i>=j) return ;
        if(i<j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            rev(s,i+1,j-1);
        }
    }
}