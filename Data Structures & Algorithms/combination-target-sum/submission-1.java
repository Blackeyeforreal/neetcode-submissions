

class Solution {
    private int target = 0; 
    private List<List<Integer>> result = new ArrayList<>();

    private void recur(int[] nums, int i, int cursum, List<Integer> ans) {
        // Base Case 1: If current sum matches target, save the combination
        if (cursum == target) {
            result.add(new ArrayList<>(ans)); // Make a deep copy
            return;
        }

        // Base Case 2: Out of bounds or sum exceeds target (pruning)
        if (i >= nums.length || cursum > target) {
            return;
        }

        // Decision 1: Include the current element nums[i] and stay at index i (allow reuse)
        ans.add(nums[i]);
        recur(nums, i, cursum + nums[i], ans);
        
        // Backtrack: Clean up the state before the next decision
        ans.remove(ans.size() - 1);

        // Decision 2: Exclude the current element nums[i] and move to the next index
        recur(nums, i + 1, cursum, ans);
    }
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.target = target;
        result.clear(); // Clear results for fresh test cases
        recur(nums, 0, 0, new ArrayList<>());
        return result;
    }
}
