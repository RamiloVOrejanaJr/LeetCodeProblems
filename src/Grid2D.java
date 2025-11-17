public class Grid2D {
    //Problem 463
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){

                if (grid[i][j] == 0) continue;

                //check cardinal neighbors
                //north neighbour
                if (i > 0) { //check if in first row
                    if (grid[i-1][j] == 0) perimeter++; //check if neighbour is water
                } else perimeter++;

                //south neighbour
                if (i < grid.length-1) { //check if in last row
                    if (grid[i+1][j] == 0) perimeter++;
                } else perimeter++;

                //west neighbour
                if (j > 0) { //check if in first column
                    if (grid[i][j-1] == 0) perimeter++;
                } else perimeter++;

                //east neighbour
                if (j < grid[i].length-1) { //check if in last column
                    if (grid[i][j+1] == 0) perimeter++;
                } else perimeter++;
            }
        }

        return perimeter;
    }
}
