class Solution {
    public int search(int[] nums, int target) {
        boolean isleft = (nums[0] <= target);
    
        int right = nums.length-1;
        int left = 0 ;  
        if( right == 0){
            if  ( nums[0] == target) return 0 ; 
            else return -1 ;
        } 

        while ( left <= right){
            int mid = left + (right - left)/2 ; 

            if   ( nums[mid] == target) return mid ; 
            if ( isleft && nums[0]>nums[mid] ) right = mid-1;
            else if (!isleft&& nums[0]<= nums[mid] ) left = mid +1; 
            else if ( nums[mid ]< target){
                left = mid + 1 ; 
            }
            else if(  nums[mid ]> target){
                right = mid - 1 ; 
            }
            

        }
        return -1 ; 
    }
}
