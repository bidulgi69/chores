import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    private static final long MOD = 1000000007;

    private static long[][] multiply(long[][] a, long[][] b) {
        int x = a.length, y = b[0].length, z = a[0].length;
        long[][] result = new long[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < z; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                result[i][j] %= MOD;
            }
        }
        return result;
    }

    static long[][] dq(long[][] matrix, long n) {
        if (n == 1) return matrix;
        else {
            long[][] divide = dq(matrix, n/2);
            if (n % 2 == 1) return multiply(multiply(divide, divide), matrix);
            else return multiply(divide, divide);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] init = {{0, 1}, {1, 1}};
        System.out.print(dq(init, n)[0][1]);
    }
}
