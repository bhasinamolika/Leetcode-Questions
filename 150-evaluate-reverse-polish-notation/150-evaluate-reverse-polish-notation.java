class Solution {
    public int eval(int x, int y, String op){
        if(op.equals("+")) return x + y;
        else if(op.equals("-")) return x - y;
        else if(op.equals("*")) return x * y;
        return x / y;
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int second = st.pop(), first = st.pop();
                st.push(eval(first, second, tokens[i]));
            } else st.push(Integer.valueOf(tokens[i]));
        }
        
        return st.pop();
    }
}