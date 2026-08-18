
class Solution {
    private int n = 0; 
    private List<List<Integer>> result = new ArrayList<>();

    private void recursion(int[] nums, int curIndex, List<Integer> ans) {
        // Base case: if we processed all elements, add a copy of the current subset to the result
        if (curIndex == n) {
            result.add(new ArrayList<>(ans));
            return;
        }

        // Decision 1: Include the current element
        ans.add(nums[curIndex]);
        recursion(nums, curIndex + 1, ans);
        
        // Backtrack: Remove the last element before trying the next decision
        ans.remove(ans.size() - 1);

        // Decision 2: Exclude the current element
        recursion(nums, curIndex + 1, ans);
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        result.clear(); // Clear previous results for multiple test cases
        recursion(nums, 0, new ArrayList<>());
        return result;
    }
}
