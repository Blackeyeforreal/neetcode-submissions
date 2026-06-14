class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
            int n = nums.size();
        map<int,int> dup ; 
        for (int i = 0;i<n;i++){
            if( dup[nums[i]]) return true ; 
            dup[nums[i]] = 1 ; 
        }

        return false ;
        
        
    }
};