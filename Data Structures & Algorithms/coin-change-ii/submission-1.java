class Solution {
    public int change(int amount, int[] coins) {
        int dp[] = new int [amount +1] ; 
        dp[0] =1 ;
       
            for (int  j =0 ;j <coins.length;j++){
                 for( int i= 0 ;i <amount ; i++){
                if ( i + coins[j] <= amount  && dp[i] !=0){
                    dp[i + coins[j] ] += dp[i];
                }

            }
        }
        return dp[amount];
    }
}
