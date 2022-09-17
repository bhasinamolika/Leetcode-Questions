class Solution {
    HashMap<String, Integer> wordToIndices;
    HashSet<Integer> wordLens;
    public List<List<Integer>> palindromePairs(String[] words) {
        wordToIndices = new HashMap<>();
        wordLens = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++)
        {
            wordToIndices.put(words[i], i);
            wordLens.add(words[i].length());
        }
        for(int i = 0; i < words.length; i++)
        {
            char[] word = words[i].toCharArray();
            char[] rword = reverse(word);
            int rwordind = wordToIndices.getOrDefault(new String(rword), -1);
            if(rwordind!=-1&&rwordind!=i)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(rwordind);
                res.add(temp);
            }
            
            int len = word.length;
            for(int n : wordLens)
            {
                if(len<=n)continue;
                String rwordsub = getReverse(word, 0, n-1);
                if(isPalindrome(word, n, word.length-1) && wordToIndices.containsKey(rwordsub))
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(wordToIndices.get(rwordsub));
                    res.add(temp);
                }
                
                rwordsub = getReverse(word, word.length-n, word.length-1);
                if(isPalindrome(word, 0, word.length-n-1) && wordToIndices.containsKey(rwordsub))
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(wordToIndices.get(rwordsub));
                    temp.add(i);
                    res.add(temp);
                }
            }
        }
        return res;
    }
    
    public boolean isPalindrome(char[] word, int l, int r)
    {
        while(l<r)
        {
            if(word[l]!=word[r])return false;
            l++;
            r--;
        }
        
        return true;
    }
    
    public String getReverse(char[] word, int l, int r)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = r; i>=l; i--)
        {
            sb.append(word[i]);
        }
        
        return sb.toString();
    }
    
    public char[] reverse(char[] arr)
    {
        int l = 0, r = arr.length-1;
        char[] res = new char[arr.length];
        for(int i = l; i <= r; i++)
        {
            res[i] = arr[i];
        }
        
        while(l<r)
        {
            char temp = res[l];
            res[l] = res[r];
            res[r] = temp;
            l++;
            r--;
        }
        
        return res;
    }
}