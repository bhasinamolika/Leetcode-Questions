class Solution {
   public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            
            if(i == 0){
                list.add(1);
                result.add(list);
            }else if(i == 1){
                list.add(1);
                list.add(1);
                result.add(list);
            }else{
                
                for(int j = 0;j<=i;j++){
                    List<Integer> prev = result.get(result.size()-1);
                    if(j == 0 || j == i){
                        list.add(1);
                    }else{
                        list.add(prev.get(j-1) + prev.get(j));
                    }
                }
                
                result.add(list);
            }
        }
        
        return result;
    }
}
