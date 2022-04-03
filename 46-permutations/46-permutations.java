class Solution {
    
    public void find(int[] nums,List<Integer> res,List<List<Integer>> ans,int visited[]){
        
        //check if all elements are included
        if(res.size()==nums.length){
            ans.add(new LinkedList(res));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            
            //check if current element is already in the res list or not
            if(visited[i]==1)continue;
            
            //if not visited then mark it as visited and add to res and call recursion for rest elements.
            visited[i]=1;
            res.add(nums[i]);
            find(nums,res,ans,visited);
            
            //remove from res list and unvisit the current element
            res.remove(res.size()-1);
            visited[i]=0;
        }
        
    }
    public List<List<Integer>> permute(int[] nums) {
        
        //list of permutations 
        List<List<Integer>> ans=new LinkedList();
        
        //stores one permutation in the recursive stack
        List<Integer> res=new LinkedList();
        
        int visited[]=new int[nums.length];
        find(nums,res,ans,visited);
        return ans;
    }
}