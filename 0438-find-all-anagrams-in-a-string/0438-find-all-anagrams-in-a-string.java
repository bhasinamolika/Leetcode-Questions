class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        if(s.length()<p.length()) return ans;
        HashMap<Character,Integer> pmap=new HashMap<>();
        for(int i=0;i<p.length();i++){
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);
        }
        HashMap<Character,Integer> CurrMap=new HashMap<>();
        for(int i=0;i<p.length();i++){
            CurrMap.put(s.charAt(i),CurrMap.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=p.length();i<s.length();i++){
            if(pmap.equals(CurrMap)) ans.add(i-p.length());
            CurrMap.put(s.charAt(i),CurrMap.getOrDefault(s.charAt(i),0)+1);
            if(CurrMap.get(s.charAt(i-p.length()))==1) CurrMap.remove(s.charAt(i-p.length()));
            else{
                CurrMap.put(s.charAt(i-p.length()),CurrMap.get(s.charAt(i-p.length()))-1);
            }
        }
        if(pmap.equals(CurrMap)) ans.add(s.length()-p.length());
        return ans;
    }
}