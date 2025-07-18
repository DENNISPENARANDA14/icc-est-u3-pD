import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursiveCompletoBT implements MazeSolver {
    private List<Cell> path;
    private Set<Cell> visited;
    private boolean[][] grid;
    private Cell end;
    
    public MazeSolverRecursiveCompletoBT() {
        this.path = new ArrayList<>();
        this.visited = new HashSet<>();
    }

    @Override
    public MazeResult getPath(boolean[][] grid, Cell start, Cell end) {
        path.clear();
        visited.clear();        
        this.grid = grid;
        this.end = end;
        
        if (grid == null || grid.length==0) {
            return new MazeResult(path, visited); // Retornar lista vacía si hay parámetros nulos
        }
        
        if (findPath(start)){
            System.out.println("ruta eoptima: " + path);
            System.out.println("ruta visitada: " + visited);
            
            return new MazeResult(path, visited); // Retornar el resultado con el camino encontrado y las celdas visitadas
        }
        return new MazeResult(path, visited);
    }

    private boolean findPath(Cell current) {
        if (!isInMaze(current)) {
            return false; // Si la celda inicial está fuera del laberinto, retornar false
        }

        if (!isValid(current)) {
            return false; // Si la celda no es válida, retornar false
        }
        
        visited.add(current); // Marcar la celda como visitada
        path.add(current); // Agregar la celda actual al camino
        

        //valido si llegue al final
        if (current.equals(end)) {
            return true; // Si llegamos al destino, retornar true
        }
        
        // me muevo en las 4 direcciones
        if (findPath(new Cell(current.row, current.col + 1)) || // Derecha
            findPath(new Cell(current.row + 1, current.col)) || // Abajo
            findPath(new Cell(current.row, current.col-1)) || // Izquierda
            findPath(new Cell(current.row-1, current.col))) { // Arriba
            return true; // Si alguna dirección retorna true, el camino es válido
        }
        path.remove(path.size() - 1); // quitar la celda del camino
        return false;
    }

    private boolean isValid(Cell current) {
        int row = current.row;
        int col = current.col;
        if (!grid[row][col] || visited.contains(current)) {
            return false; // Si la celda ya fue visitada o no es transitable,
        }
        return true;
    }

    private boolean isInMaze(Cell current) {
        int row = current.row;
        int col = current.col;
        if (row < 0 || row>=grid.length || col < 0 || col >= grid[0].length) {
            return false; // Fuera de los límites del laberinto
        }
        return true; // Dentro de los límites del laberinto
    }   
}
