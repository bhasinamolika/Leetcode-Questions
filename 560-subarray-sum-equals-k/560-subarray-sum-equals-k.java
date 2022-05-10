class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt=0;
        int sum=0;
        HashMap<Integer,Integer> aux=new HashMap<>();
        aux.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(aux.containsKey(sum-k))
                cnt+=aux.get(sum-k);
            aux.put(sum,aux.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}