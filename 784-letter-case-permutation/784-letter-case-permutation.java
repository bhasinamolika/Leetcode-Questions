class Solution {
    public List<String> letterCasePermutation(String s) {
        // input is s
        String op="";
        List<String> ans=new ArrayList<>();
        solve(s,op,ans);
        return ans;
    }
    void solve(String ip,String op,List<String> ans){
        if(ip.length()==0){
            ans.add(op);
            return ;
        }
        if(Character.isDigit(ip.charAt(0))){
            op=op+ip.charAt(0);
            solve(ip.substring(1),op,ans);
        }
        else{
            String op1=op+""+Character.toUpperCase(ip.charAt(0));
            String op2=op+""+Character.toLowerCase(ip.charAt(0));
            solve(ip.substring(1),op1,ans);
            solve(ip.substring(1),op2,ans);
        }
        return;
    }
}