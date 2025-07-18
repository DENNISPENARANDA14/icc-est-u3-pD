

public interface MazeSolver {
    //List<Cell> getPath(boolean[][] grid, Cell start, Cell end);
    MazeResult getPath(boolean[][] grid, Cell start, Cell end);
}
