class Solution {
    public boolean canReach(int[] arr, int start) {
        
        
        if(start>=arr.length || start<0)
            return false;
        if(arr[start]==0)
            return true;
        if(arr[start]==-1) return false;
        int aux=arr[start];
        arr[start]=-1;
        boolean ans= canReach(arr,start+aux) || canReach(arr,start-aux);
        arr[start]=aux;
        return ans;
    }
}