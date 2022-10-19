


class Solution {
public int lengthOfLongestSubstring(String s) {

    Map<Character,Integer> indexCountMap = new HashMap<>();
    int startIndex = 0;
    int maxCount = 0;
    int tempCount = 0;
    for(int i=0;i<s.length();i++){
        
        if(indexCountMap.containsKey(s.charAt(i))){
            
            if(indexCountMap.get(s.charAt(i)) >= startIndex){
                
                int temp = startIndex;

                startIndex = indexCountMap.get(s.charAt(i))+1;

                int diff = startIndex - temp;
                tempCount = tempCount - diff;
                
            }
            tempCount ++;
            
            
            indexCountMap.put(s.charAt(i),i);
        }else{                
            tempCount ++;
            indexCountMap.put(s.charAt(i),i);
        }
        
        if(maxCount<tempCount){
            maxCount = tempCount;
        }
    }
    
    return maxCount;
    
}
}