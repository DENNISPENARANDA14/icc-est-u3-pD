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
}
