class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int i =grid.length-1;
        int j = 0;
        while ( i >= 0 && j<grid[0].length){
            
            if( grid[i][j] >= 0)
            {
                j++;
            }
            else
            {
                count +=(grid[0].length-j);
                 i--;
            }
        }
        return count;
    }
}