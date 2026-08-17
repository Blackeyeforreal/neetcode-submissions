class Solution {
    public int findMin(int[] nums) {
        int start  = 0 ; 
        int end = nums.length -1 ; 
        if ( end ==0 )return nums[0];
        if ( nums[start] <nums[end]) return nums[start];

        while ( start <= end){
            int mid = start +(end - start)/2 ;


            if ( nums[mid] >= nums[0]){
                start = mid+1 ; 
            }
            else if ( nums[mid] < nums[0]){
                end = mid -1 ; 

            }
        }
        return nums[start];
    }
}
