import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MazeSolverREcursive implements MazeSolver {
    @Override
    public MazeResult getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        // validamos si es igual a nulo retornamos new ArrayList
        if (grid == null || grid.length == 0) {
            return new MazeResult(path, new HashSet<>()); // Retornar lista vacía si hay parámetros nulos
        }
        
        if (findPath(grid, start, end, path)) {
            return new MazeResult(path, new HashSet<>()); // Retornar el resultado con el camino encontrado y las celdas visitadas
        }
        return new MazeResult(path, new HashSet<>()); // Retornar lista vacía si no se encuentra un camino
    }
    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
        // valido si la celda inicio su fila esta dentro de mi grid
        //valiodo si la celdainicio  si row esta dentro de mi grid
        //valido si la celda es transitable == true
        int row = start.row;
        int col = start.col;
        if (row >=grid.length || col >= grid[0].length || grid[row][col] == false) {
            return false; // Invalid cell
        }
        if (row == end.row && col == end.col) {
            path.add(start);
            return true;
        }
        if (findPath(grid, new Cell(row + 1, col), end, path) || 
            findPath(grid, new Cell(row, col + 1), end, path)) {
            path.add(start); 
            return true; 
        }
        return false;
    }
    
}
