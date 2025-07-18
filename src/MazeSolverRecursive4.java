import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursive4 implements MazeSolver {
    @Override
    public MazeResult getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        Set<Cell> visited = new HashSet<>();

        if (findPath(grid, start.row, start.col, end, path, visited, start, end)) {
            return new MazeResult(path, visited); // Retornar el resultado con el camino encontrado y las celdas visitadas
        }
        return new MazeResult(path, visited);
    }

    private boolean findPath(boolean[][] grid, int row, int col, Cell end, List<Cell> path, Set<Cell> visited,
            Cell start, Cell finalEnd) {
        // Verificar límites y si la celda es transitable
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false;
        }

        Cell cell = new Cell(row, col);
        if (visited.contains(cell)) {
            return false; // Evitar ciclos
        }

        visited.add(cell); // Marcar celda como visitada

        // Si llegamos al destino, agregamos la celda al camino y retornamos true
        if (row == end.row && col == end.col) {
            path.add(cell);
            return true;
        }

        // Intentar moverse en cada dirección
        if (findPath(grid, row, col + 1, end, path, visited, start, finalEnd)) { // Derecha
            path.add(cell);
            return true;
        }
        if (findPath(grid, row + 1, col, end, path, visited, start, finalEnd)) { // Abajo
            path.add(cell);
            return true;
        }
        if (findPath(grid, row - 1, col, end, path, visited, start, finalEnd)) { // Arriba
            path.add(cell);
            return true;
        }
        if (findPath(grid, row, col - 1, end, path, visited, start, finalEnd)) { // Izquierda
            //izquierda
            path.add(cell);
            return true;
        }

        return false; // No se encontró un camino válido
    }
}
