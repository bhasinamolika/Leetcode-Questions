class Solution {
    public class Point implements Comparable<Point> {
		private int x;
		private int height;

		public Point(int x, int height) {
			this.x = x;
			this.height = height;
		}

		public int compareTo(Point o) {
			if (this.x != o.x) {
				return this.x - o.x;
			} else {
				return this.height - o.height;
			}
		}
	}
    //find the a points that change the max height among the buildings on the left
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<Point> points = new ArrayList<>();
		for(int[]point : buildings) {
			points.add(new Point(point[0], -point[2]));// start of a building, height stored as negtive
			points.add(new Point(point[1], point[2]));// end of a building, height stored as positive
		}
	
		Collections.sort(points);//sort the points based on x. if x is same then sort based on height
		List<List<Integer>> ans = new ArrayList<>();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		priorityQueue.add(0);
		for (Point point : points) {
			int top = priorityQueue.peek();
			if (point.height < 0) { //this means a new building, so add it to priorityQueue
				priorityQueue.add(-point.height); 
			} else { // this means it has reached the end of the building, so remove it from priorityQueue
				priorityQueue.remove(point.height);
			}
            // if the max height is different from the previous one, that means a point is found that change the max height among the buildings on the left, add to result list
			if (top != priorityQueue.peek()) {
				List<Integer> curr = new ArrayList<>();
				curr.add(point.x);
				curr.add(priorityQueue.peek());
				ans.add(curr);
			}
		}
		return ans;
	}
}