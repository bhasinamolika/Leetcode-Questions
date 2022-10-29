//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class TrieNode {
    private TrieNode[] levels;
    private boolean isEnd;
    
    public TrieNode() {
        levels = new TrieNode[256];
    }
    
    public boolean containsKey(char ch) {
        return levels[ch] != null;
    }
    
    public void put(char ch, TrieNode node) {
        levels[ch] = node;
    }
    
    public TrieNode get(char ch) {
        return levels[ch];
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean getEnd() {
        return isEnd;
    }
}

class Solution{
    private static TrieNode root;
    private static ArrayList<ArrayList<String>> res;
    
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s)
    {
        // code here
        root = new TrieNode();
        res = new ArrayList<>();
        
        for (String c : contact) {
            insert(c);
        }
        
        search(s, 0, new StringBuilder());
        
        return res;
    }
    
    private static void insert(String word) {
        TrieNode node = root;
        
        for (int i = 0 ; i < word.length() ; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        
        node.setEnd();
    }
    
    private static void search(String s, int idx, StringBuilder str) {
        TrieNode node = root;
        boolean signal = false;
        
        for (int i = 0 ; i < s.length() ; i++) {
            
            ArrayList<String> list = new ArrayList<>();
            char ch = s.charAt(i);
            
            if (signal) {
                list.add("0");
            } else {
                if (node.containsKey(ch)) {
                    str.append(ch);
                    node = node.get(ch);
                    completeWord(node, str, list);
                } else {
                    signal = true;
                    list.add("0");
                }
            }
            
            res.add(list);
        }
    }
    
    private static void completeWord(TrieNode node, StringBuilder str, ArrayList<String> list) {
        if (node.getEnd()) {
            list.add(str.toString());
        }
        
        for (int i = 0 ; i < 256 ; i++) {
            char ch = (char)(i);
            
            if (node.containsKey(ch)) {
                str.append(ch);
                completeWord(node.get(ch), str, list);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }
}