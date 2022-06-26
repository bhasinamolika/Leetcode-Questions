class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max_score = 0, total_score = 0, curr_score = 0, n=cardPoints.length;
        for(int points : cardPoints)    total_score += points;
        if(n == k)  return total_score;
        for(int i=0; i<n-k-1; i++)  curr_score += cardPoints[i];
        for(int i=n-k-1; i<n; i++){
            curr_score += cardPoints[i];
            max_score = Math.max(max_score, total_score - curr_score);
            curr_score -= cardPoints[i-(n-k-1)];
        }   
        return max_score;
    }
}