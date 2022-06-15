class Solution {
    public int longestStrChain(String[] words) {

		int max = 0;
		int[] dp = new int[words.length];
		Arrays.sort(words, (a, b) -> a.length() - b.length());

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++)
			map.put(words[i], i);

		StringBuilder sb;
		String tp;

		for (int i = words.length - 1; i >= 0; i--) {
			sb = new StringBuilder();
			sb.append(words[i]);

			for (int j = 0; j < words[i].length(); j++) {
				tp = sb.deleteCharAt(j).toString();
				if (map.containsKey(tp))
					dp[map.get(tp)] = Math.max(dp[map.get(tp)], 1 + dp[i]);
				sb.insert(j, words[i].charAt(j));
			}

			if (dp[i] > max)
				max = dp[i];
		}

		return max + 1;
	}
}