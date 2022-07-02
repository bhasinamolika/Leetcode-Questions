class Solution {

public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    int mod=(int)Math.pow(10,9)+7;
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    long maxr=horizontalCuts[0];
    long maxc=verticalCuts[0];
    int rl=horizontalCuts.length;
    int cl=verticalCuts.length;
    for(int i=1;i<rl;i++){
        maxr=Math.max(maxr,horizontalCuts[i]-horizontalCuts[i-1]);
    }
    maxr=Math.max(maxr,h-horizontalCuts[rl-1]);
    for(int i=1;i<cl;i++){
        maxc=Math.max(maxc,verticalCuts[i]-verticalCuts[i-1]);
    }
    
    maxc=Math.max(maxc,w-verticalCuts[cl-1]);
        long res=(maxr%mod)*(maxc%mod);
        res=res%mod;
        return (int)res;
    
    
}
}