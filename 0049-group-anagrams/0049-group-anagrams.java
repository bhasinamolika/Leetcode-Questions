class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        
        for(String s:strs){
		
            //converts each string in array to char array
            char[] temp=s.toCharArray();
            Arrays.sort(temp);
            String key=new String(temp);
			
            //compares if the sorted string exists in the hashmap...if not then another list is created ..else the current traversing list is added to list mapped to the sorted string
			
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}