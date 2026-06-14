class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        map<int , int > track ; 
        int ans  = 0 ; 
sort( nums.begin(), nums.end());
        for(auto n : nums){
            if ( track.contains(n-1)) {
                track[n] = track[n-1] +1 ;
                ans = max(ans, track[n]); 
            }else {
                track[n]= 1;
                                ans = max(ans, track[n]); 

            }
        }
        return ans ; 
    }
};
