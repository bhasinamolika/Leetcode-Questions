class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l=new ArrayList<>();
        String op="";
        int open=n;
        int close=n;
        solve(open,close,op,l);
        return l;
    }
    void solve(int open,int close,String op,List<String> l){
        if(open==0 && close==0){
            l.add(op);
            return;
        }
        if(open!=0){
            String op1=op+"(";
            solve(open-1,close,op1,l);
        }
        if(close!=0 && close>open){
            String op2=op+")";
            solve(open,close-1,op2,l);
        }
        return;
    }
}