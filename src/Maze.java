import java.util.List;
import java.util.Set;

public class Maze {
    private boolean[][] maze;

    public Maze(boolean[][] maze) {
        this.maze = maze;
    }
    public boolean[][] getGrid() {
        return maze;
    }

    public void printMaze() {
        for (boolean[] row : maze) {
            for (boolean cell : row) {
                System.out.print(cell ? " - " : " * ");
            }
            System.out.println();
        }
    }
    public void printMazeWithPath(List<Cell> path) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                Cell cell = new Cell(i, j);
                if (path.contains(cell)) {
                    System.out.print(" P "); // P para Path
                } else {
                    System.out.print(maze[i][j] ? " - " : " * ");
                }
            }
            System.out.println();
        }
    }
    public void printMazeWithVisited(Set<Cell> visited) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                Cell cell = new Cell(i, j);
                if (visited.contains(cell)) {
                    System.out.print(" V "); // V para Visited
                } else {
                    System.out.print(maze[i][j] ? " - " : " * ");
                }
            }
            System.out.println();
        }
    }
}
