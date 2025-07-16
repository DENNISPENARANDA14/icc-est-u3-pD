public class EjerciciosPD {
    public long getFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
    public long getFibonacciPD(int n) {
        long[] fib = new long[n + 1];
        fib[0] = 0;
        if (n > 0) {
            fib[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
    
}
