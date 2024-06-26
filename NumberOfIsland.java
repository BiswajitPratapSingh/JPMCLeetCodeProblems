/* 200. Number of Island
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

Approach :


*/
class NumberOfIslands {
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) {
            return 0;
        }

        int islands = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    countIslands(grid,i,j);
                    islands++;

                }
            }
        }

        return islands;
    }

    public void countIslands(char[][] grid, int row, int col) {

      if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
        return;
      }
       //Mark Visited Cell as True
        grid[row][col] = '0';

        countIslands(grid, row+1,col); //Up
        countIslands(grid, row-1,col); //dowm
        countIslands(grid, row,col+1); // right
        countIslands(grid, row,col-1); //Left

    }
}
