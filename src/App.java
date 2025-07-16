public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        runEjerciciosPD();
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
