class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int ans=0;
        for(String token:tokens){
            if(token.equals("+")){
                int top=st.pop();
                int second=st.pop();
                st.push(top+second);
            }
            else if(token.equals("-")){
                int top=st.pop();
                int second=st.pop();
                st.push(second-top);
            }
            else if(token.equals("*")){
                int top=st.pop();
                int second=st.pop();
                st.push(top*second);
            }
            else if(token.equals("/")){
                int top=st.pop();
                int second=st.pop();
                st.push(second/top);
            }
            else
                st.push(Integer.parseInt(token));
        }
        ans=st.pop();
        return ans;
    }
}