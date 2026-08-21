class Solution {
    public int numDecodings(String s) {
        int n  = s.length(); 
        int [] dp = new int[n+1];
        dp[0] =s.charAt(0) =='0'?0:1;

        for (int i = 0 ;i < n;i++){
            if (s.charAt(i) !='0' )
            dp[i+1] +=dp[i]; 
            if ( i>0 && Integer.parseInt(s.substring(i-1,i+1)) <=26 && s.charAt(i-1)!='0'){
                dp[i+1]+= dp[i-1] ;
            }
        }
        return dp[n];
    }
}