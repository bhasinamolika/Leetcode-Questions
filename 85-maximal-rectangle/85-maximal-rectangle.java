class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length; 
        int maxRect = 0; 
        
        int[] arr = new int[n];
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == '1'){
                    arr[j] += 1; 
                }else{
                    arr[j] = 0; 
                }
            }
            int currAns = maxAreaHistogram(arr); 
            maxRect = Math.max(maxRect, currAns); 
        }
        return maxRect; 
    }
    
    private int maxAreaHistogram(int heights[]){
        int n = heights.length; 
        int[] ps = getPrevSmaller(heights); 
        int[] ns = getNextSmaller(heights); 
        
        int maxArea = 0; 
        for(int i = 0; i<n; i++){
            int area = heights[i] * (ns[i]-ps[i]-1); 
            maxArea = Math.max(area, maxArea); 
        }
        return maxArea;       
    }
    
    private int[] getPrevSmaller(int[] arr){
        int n = arr.length; 
        int[] ps = new int[n]; 
        Stack<Integer> s = new Stack<>(); 
        for(int i = 0; i<n; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop(); 
            }
            if(s.isEmpty()){
                ps[i] = -1; 
            }else{
                ps[i] = s.peek();
            }
            s.push(i); 
        }
        return ps; 
    }
    
    private int[] getNextSmaller(int[] arr){
        int[] ns = new int[arr.length]; 
        int n = arr.length; 
        Stack<Integer> s = new Stack<>(); 
        for(int i = n-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop(); 
            }
            if(s.isEmpty()){
                ns[i] = n; 
            }else{
                ns[i] = s.peek();
            }
            s.push(i); 
        }
        return ns; 
    }
}