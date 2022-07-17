class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            int firstSum = 0;

            while (firstNum != 0) {
                firstSum += firstNum % 10;
                firstNum = firstNum / 10;
            }

            if (map.containsKey(firstSum)) {
                if (nums[map.get(firstSum)] + nums[i] > maxSum) {
                    maxSum = nums[map.get(firstSum)] + nums[i];
                }
                if (nums[i] > nums[map.get(firstSum)]) {
                    map.put(firstSum, i);
                }
            } else {
                map.put(firstSum, i);
            }
        }
        return maxSum;
    }
}