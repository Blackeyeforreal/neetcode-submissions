class Solution {

   
    public int minEatingSpeed(int[] piles, int h) {
        int start =1 ; int end =0 ;
        for(int i = 0 ;i<piles.length;i++) end = 
        Math.max(end, piles[i]);
        
        int ans =0 ;
        while( start <= end){
            int mid = start + ( end - start)/2 ; 
            
            int val =0 ;
            for(int i = 0 ; i < piles.length;i++){
                val += (piles[i] +( mid-1))/mid;
            }
            if (val <=h){
                ans = mid ; 
                end = mid -1 ; 
            }
            else if ( val > h){
                start = mid +1 ; 
            }
        }
        return ans ;

    }
}
