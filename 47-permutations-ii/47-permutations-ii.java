class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);

		Map<Integer, Integer> map = new HashMap<>();
		//store the amount for each number
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		backtrack(res, new ArrayList<>(), map, nums);
		return res;
	}

	void backtrack(List<List<Integer>> res, List<Integer> path, Map<Integer, Integer> map, int[] nums) {
		if (path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			final int cur = nums[i];
			if (i > 0 && cur == nums[i -1]) {
				continue;
			}

			// no available number to use
			if (map.get(cur) <= 0) {
				continue;
			}

			//comsume the number
			map.put(cur, map.get(cur) - 1);

			path.add(cur);
			backtrack(res, path, map, nums);
			path.remove(path.size() - 1);

			//revoke use
			map.put(cur, map.get(cur) + 1);
		}
	}
}