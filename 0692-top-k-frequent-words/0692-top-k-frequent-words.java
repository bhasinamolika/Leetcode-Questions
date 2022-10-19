class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        List<String> ans=new ArrayList<>();
        for(String word:words){
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<String> pq=new PriorityQueue<>((w1,w2)->hm.get(w1)==hm.get(w2)?w2.compareTo(w1):hm.get(w1)-hm.get(w2));
        
        for(String word:hm.keySet()){
            
            pq.offer(word);
            
            if(pq.size()>k)
                pq.poll();
            
        }
        
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        
        Collections.reverse(ans);
        return ans;
    }
}