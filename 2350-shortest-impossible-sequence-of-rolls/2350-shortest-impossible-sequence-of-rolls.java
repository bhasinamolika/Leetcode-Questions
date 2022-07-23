class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int roll : rolls) {
            set.add(roll);
            if(set.size() == k) {
                count++;
                set.clear();
            }
        }
        return count + 1;
    }
}
