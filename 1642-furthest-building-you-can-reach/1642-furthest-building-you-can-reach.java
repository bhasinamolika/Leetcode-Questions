class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0; i<heights.length-1; i++) {
            if(heights[i] > heights[i+1]) {
                continue;
            }
            int diff = heights[i+1] - heights[i];
            minHeap.add(diff);
            if(minHeap.size() > ladders) {
                bricks = bricks - minHeap.poll();
            }
            
            if(bricks < 0) {
                return i;
            }
        }
        return heights.length-1;
    } 
}