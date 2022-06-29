class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people, (a, b)-> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);
        List<int[]> list = new LinkedList<>();
        
        for(int[] arr: people){
            
            list.add(arr[1], arr);
        }
        return list.toArray(new int[people.length][2]);
    }
}