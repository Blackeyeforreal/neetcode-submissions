class Solution {
    public int rob(int[] nums) {
      
        int n = nums.length; 
          if ( n==1) return nums[0];
        int [] dp = new int [n+1 ] ;
        dp[0] = nums[0];
        if ( n>1)
        dp[1] = nums[1];
        for (int i = 0;i<n;i++){
            if (i-2 >=0){
                dp[i] = Math.max(dp[i] , dp[i-2] + nums[i]);
            }
             if (i-3 >=0){
                dp[i] = Math.max(dp[i] , dp[i-3] + nums[i]);
             }
        }
        return Math.max(dp[n-2],dp[n-1]) ;
    }
}
