class Solution {
public:

    vector<int> twoSum(vector<int>& nums, int target) {
        map<int , int> av; 
        int n = nums.size();
        for (int i = 0 ;i <n;i++){
            if ( av[nums[i]]) return {av[nums[i]]-1 , i};
            av[target - nums[i]] =i +1;
        }
        return {0,0};
    }
};
