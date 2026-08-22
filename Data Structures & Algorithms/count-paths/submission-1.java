class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m+2][n+2];
        dp[0][1] = 1 ; 
        dp[1][0]=0;
        
           
        for(int i =0 ;i <m;i++){
           
            for(int  j =0 ; j <n;j++){
              
                dp[i+1][j+1] = dp[i+1][j] +dp[i][j+1];
            }
        }
        return dp[m][n];
        
    }
}
