class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<Integer,Integer> winners=new HashMap<>();
        HashMap<Integer,Integer> losers=new HashMap<>();
        List<Integer> win=new ArrayList<>();
        List<Integer> lose=new ArrayList<>();
        for(int i=0;i<matches.length;i++){
            winners.put(matches[i][0],winners.getOrDefault(matches[i][0],0)+1);
            losers.put(matches[i][1],losers.getOrDefault(matches[i][1],0)+1);
        }
        for(int player:winners.keySet()){
            if(!losers.containsKey(player))
                win.add(player);
        }
        Collections.sort(win);
        ans.add(win);
        for(int player:losers.keySet()){
            if(losers.get(player)==1)
                lose.add(player);
        }
        Collections.sort(lose);
        ans.add(lose);
        return ans;
    }
}