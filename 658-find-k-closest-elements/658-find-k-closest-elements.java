class Solution {
    class Pair {
        int key, value;
        Pair(int diff, int num) {
            this.key = diff;
            this.value = num;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (b.key == a.key) return b.value - a.value;
                return b.key - a.key;
            }
        });
        for (int i : arr) {
            heap.add(new Pair(Math.abs(i - x), i));
            if (heap.size() > k) 
                heap.remove();
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) res.add(heap.remove().value);
        Collections.sort(res);
        return res;
    }
}