class MedianFinder {

//maxQueue to store left side of numbers
PriorityQueue<Integer> maxQueue;
// minQueue to store right side of numbers
PriorityQueue<Integer> minQueue;

public MedianFinder() {
    // higher number will be the first number from right side
    maxQueue = new PriorityQueue<>(Collections.reverseOrder());
    // lower number will be the first number from right side
    minQueue = new PriorityQueue<>();
}

public void addNum(int num) {
    
    if(maxQueue.isEmpty() || (maxQueue.peek() > num)) {
        maxQueue.add(num);
    } else {
        minQueue.add(num);
    }
    
    if(maxQueue.size() > minQueue.size() + 1) {
        minQueue.add(maxQueue.poll());
    }
    
    if(minQueue.size() > maxQueue.size() + 1) {
        maxQueue.add(minQueue.poll());
    }
}

public double findMedian() {
    
    if(maxQueue.size() == minQueue.size()) {
        return ((maxQueue.peek() + minQueue.peek()) / 2.0);
    } else if(maxQueue.size() > minQueue.size()) {
        return maxQueue.peek();
    } else {
        return minQueue.peek();
    }
}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */