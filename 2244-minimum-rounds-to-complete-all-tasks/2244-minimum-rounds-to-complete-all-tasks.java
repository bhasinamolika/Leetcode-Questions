class Solution {
    public int minimumRounds(int[] tasks) {
        /*
        Q1: how do we know from where to begin?
        May be we scan the task array first and store min task and max task along with there occurences?
        Update: since we have used map, we dont need min and max
        Q2: will it matter if i delete 2 task vs 3 task at a time? 
        Yes, example 6 task - if we go via 2,2,2 then its 3 times. if we go via 3,3 then thats 2
        for 4 task we need to plan properly it should be  2,2
        
        so lets decide:
        
        lets say number is x;
		% is remainder funcation
		
        x - try with 3 if x%3 == 0 divide by 3
		
        x - try with 3 if x%3  >0 and ==2 . after divide by 3 we get 2 as remainder.  x =  3*n +  2 i.e. count=> n +1
        example 5, 8, 11 ...
        5/3 -> 1  --> 1+1 
        11/3 -> 3 --> 3 +1
        
        x - try with 3 if % > 0 and ==1. after divide by 3 we get 1 as remainder.  x = (n-1)*3 + 2*2  i.e. count=> (n-1) + 2
        example 4,7 10 13...
        4/3 -> 1 - > 0 +2; here n =1
        7/3 -> 2 -> 1+ 2;  here n =2
        
        Q3: when is it not possible to do a task?
        when initial count is less than 2
        
        */
        
        
        Map<Integer,Integer> map = new HashMap<>();
       //int min = 0;
       // int max = 0;
        for(int task: tasks){
            
            if(!map.containsKey(task)){
                map.put(task, 0);
            }
            
           // min = Math.min(min, task);
           // max = Math.max(max, task);
            map.put(task, map.get(task)+1);
        }
        
        int count = 0;
        for(Integer key : map.keySet()){
            
            if(map.get(key) <2)
                return -1;
            
            int value = map.get(key);
            if(value%3==0){
                count += value/3;
            }else if(value%3 ==2){
                count += value/3 +1;
            }else if(value%3 ==1){
                count += ((value/3) -1) +2;
            }
        }
        
        return count;
        
        
        
        
    }
}