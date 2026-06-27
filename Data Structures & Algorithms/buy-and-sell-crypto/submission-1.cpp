class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int l = 1e9; int n = prices.size();
        int ans =0 ; 
        for(int i =0 ; i<n;i++){
            l = min ( l,prices[i]);
            ans = max(ans, prices[i] - l );
        }
        return ans ;
    }
};
