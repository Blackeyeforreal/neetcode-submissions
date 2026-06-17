class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        sort(nums.begin(), nums.end());
        
        for (int x = 0; x < nums.size(); x++) {
            // Skip duplicate values for the first element
            if (x > 0 && nums[x] == nums[x - 1]) continue;
            
            int target = -nums[x];
            int i = x + 1;
            int j = nums.size() - 1;
            
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                } else {
                    res.push_back({nums[x], nums[i], nums[j]});
                    i++;
                    j--;
                    
                    // Skip duplicate values for the second element
                    while (i < j && nums[i] == nums[i - 1]) i++;
                }
            }
        }
        return res;
    }
};