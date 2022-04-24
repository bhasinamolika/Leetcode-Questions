class UndergroundSystem {
    HashMap<Integer,HashMap<String,Integer>> checkIN;
    HashMap<String,LinkedList<Integer>> diff;
    public UndergroundSystem() {
        checkIN = new HashMap<Integer,HashMap<String,Integer>>();
        diff = new HashMap<String,LinkedList<Integer>>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        hm.put(stationName,t);
        checkIN.put(id,hm);
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(checkIN.containsKey(id)){
            HashMap<String,Integer> res = checkIN.get(id);
            String key="";
            int time=t;
            for(Map.Entry<String,Integer> e:res.entrySet()){
                key+=e.getKey();
                time-=(int)e.getValue();
            }
            key+=" "+stationName;
            if(!diff.containsKey(key)){
                LinkedList<Integer> innerArr = new LinkedList<Integer>();
                innerArr.add(time);
                innerArr.add(1);
                diff.put(key,innerArr);
            }
            else{
                LinkedList<Integer> innerArr = diff.get(key);
                int prevTime = innerArr.get(0)+time;
                int prevCnt = innerArr.get(1)+1;
                innerArr.clear();
                innerArr.add(prevTime);
                innerArr.add(prevCnt);
                diff.put(key,innerArr);
            }
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        String key = "";
        key=startStation+" "+endStation;
        int val = diff.get(key).get(0);
        int c = diff.get(key).get(1);
        return (double)val/c;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */