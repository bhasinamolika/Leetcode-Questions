class Solution {
    public int calPoints(String[] ops) {
        ArrayList<Integer> record=new ArrayList<>();
        int score=0;
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("+")){
                int sum=record.get(record.size()-1)+record.get(record.size()-2);
                record.add(sum);
            }
            else if(ops[i].equals("D")){
                record.add(record.get(record.size()-1)*2);
            }
            else if(ops[i].equals("C")){
                record.remove(record.size()-1);
            }
            else{
                 record.add(Integer.parseInt(ops[i]));
            }
        }
        for(int el:record){
            score+=el;
        }
        return score;
    }
}