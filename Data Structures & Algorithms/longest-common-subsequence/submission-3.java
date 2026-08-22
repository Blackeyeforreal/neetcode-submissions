class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        if ((text2.length() > text1.length()) )
 {        String temp = text2;
        text2= text1 ; 
        text1 = temp ; 
        }

        int n = text1.length();
        int m = text2.length();

        int [][] dp = new int [n][m];
        for(int i= 0 ;i <n;i++){
            for(int j =0 ; j<m;j++){
                int isSame = (text1.charAt(i) == text2.charAt(j))?1:0;
                dp[i][j] = Math.max( (j>0)?dp[i][j-1]:0 , isSame  +  ((j>0&&i>0)?dp[i-1][j-1] : 0) );
                dp[i][j] = Math.max(dp[i][j], (i>0)?dp[i-1][j] :0);
            }
        }
        return dp[n-1][m-1];

    }
}
