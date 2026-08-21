

class Solution {
    public int lengthOfLIS(int[] nums) {
        // Handle empty input guard case
        if (nums == null || nums.length == 0) return 0;

        List<Integer> dp = new ArrayList<>();
        
        // Loop through the input array elements
        for (int i = 0; i < nums.length; i++) {
            // Use Collections for List binary search
            int index = Collections.binarySearch(dp, nums[i]); 
            
            // If element is not found, calculate its insertion point
            if (index < 0) {
                index = -(index + 1); 
            }
            
            // If insertion point matches size, append it to the end
            if (index == dp.size()) {
                dp.add(nums[i]);
            } else {
                // Otherwise, replace the element to maintain the smallest tail
                dp.set(index, nums[i]);
            }
        }
        // Return the final size of the list
        return dp.size();
    }
}
