class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length;
        int m = matrix[0].length; 

        int r = n*m-1; 
        int l = 0 ; 
        while ( l <=r ){
            int mid = l + (r-l)/2 ;
            int val =  matrix[mid/m][mid%m] ;
            if (val>target ){
                r = mid -1 ; 
            }
            else if (val<target ) l = mid +1 ; 
            else return true ;



        }
        return false ; 
    }
}
