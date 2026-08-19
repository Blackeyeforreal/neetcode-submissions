class Solution {
    public int numIslands(char[][] grid) {
        int ans =0 ;
        Queue<int[]> count = new LinkedList<>();
      int[][] ways = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int n= grid.length;
        int m= grid[0].length;

    
        for(int row = 0 ;row<n;row++){
            for(int col = 0;col<m;col++){
                if ( grid[row][col] == ('1')){
                    count.offer(new int []{row,col});
                     grid[row][col] = '0'; 
                    ans++;
                    while (!count.isEmpty()){
                        int [] cur = count.poll();
                       
                        for( int[] way : ways){
                            int i = cur[0] + way[0];
                            int j = cur[1] + way[1];

                            if ( i >=0 &&j>=0 && i<n && j<m ){
                                if ( grid[i][j] =='1' ){
                                     grid[i][j] = '0'; 
                                    count.offer(new int []{i,j});
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans ;
       
    }
}
