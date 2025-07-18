
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        //runEjerciciosPD();
        runMaze();

        
    }
    private static void runMaze() {
        boolean[][] predefinedMaze = {
            {true, true, true, true},
            {false, true, false, true},
            {true, true, false, false},
            {true, true, true, true},
        };
        Maze maze = new Maze(predefinedMaze);
        System.out.println("DENNIS ALEJANDRO PENARANDA TELLO");
        System.out.println("laberinto cargado correctamente");
        maze.printMaze();
        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);

        
        List<MazeSolver> solvers = Arrays.asList(
            //new MazeSolverREcursive();
            new MazeSolverRecursiveCompletoBT()
        );
         /* 
        MazeSolver solver = solvers.get(0);
        List<Cell> path;
        path = solver.getPath(maze.getGrid(), start, end);
        System.out.println("Camino Encontrado con 2 opciones:");
        System.out.println(path);

        List<MazeSolver> solvers1 = Arrays.asList(
            new MazeSolverRecursive4()
        );
        MazeSolver solver1 = solvers.get(0);
        List<Cell> path1;
        path = solver.getPath(maze.getGrid(), start, end);
        System.out.println("Camino Encontrado con 4 opciones:");
        System.out.println(path);

        List<MazeSolver> solvers2 = Arrays.asList(
            new MazeSolverRecursiveCompletoBT()
        );
        MazeSolver solver2 = solvers2.get(0);
        List<Cell> path2;
        path2 = solver2.getPath(maze.getGrid(), start, end);
        System.out.println("Camino Encontrado con opciones:");
        System.out.println(path2);*/
        
        MazeSolver solver3 = solvers.get(0);
        MazeResult resultado;
        resultado = solver3.getPath(maze.getGrid(), start, end);
        System.out.println("Camino Encontrado:");
        System.out.println(resultado.getPath());
        System.out.println("Celdas visitadas:");
        maze.printMazeWithVisited(resultado.getVisited());
        System.out.println("camino recorrido:");
        maze.printMazeWithPath(resultado.getPath());
        
    }

    private static void runEjerciciosPD() {
        EjerciciosPD ejercicios = new EjerciciosPD();
        System.out.println("EjerciciosPD instance created.");
        System.out.println("fibonacci Recursivo");
        long inicial = System.nanoTime();
        long resultado = ejercicios.getFibonacci(50);
        long end = System.nanoTime();
        long duration = end - inicial;
        System.out.println("Resultado: " + resultado + " Duration: " + duration/1_000_000_000 + " seconds");
        
        System.out.println("fibonacci recursivo Cacheado");
        long inicialCacheado = System.nanoTime();
        resultado = ejercicios.getFibonacciPD(100);
        long endCacheado = System.nanoTime();
        long durationCacheado = endCacheado - inicialCacheado;
        System.out.println("Resultado: " + resultado + " Duration: " + durationCacheado/1_000_000_000+ " seconds");  
    }
}
