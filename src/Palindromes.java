import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Palindromes extends PrintWriter {

    final long mod = 1_000_000_000 + 7;

    long inv(long num) {
        long inv = 1;

        for (long pwr = mod - 2; pwr > 0; pwr /= 2) {
            if (pwr % 2 == 1) {
                inv = (inv * num) % mod;
            }
            num = (num * num) % mod;
        }

        return inv;
    }

    public void run() {

        char[] str = next().toCharArray();
        int n = str.length;
        int k = 26;

        int[][] sum = new int[n + 1][k];

        for (int i = 0; i < n; i++) {
            for (int c = 0; c < k; c++) {
                sum[i + 1][c] = sum[i][c];
            }
            ++sum[i + 1][str[i] - 'a'];
        }

        long[] f = new long[n + 1];
        f[0] = 1;

        for (int i = 1; i <= n; i++) {
            f[i] = (f[i - 1] * i) % mod;
        }

        int q = nextInt();

        for (int t = 0; t < q; t++) {
            int l = nextInt() - 1, r = nextInt();

            int m = 0;
            int e = 0;

            long p = 1;

            for (int c = 0; c < k; c++) {
                int s = sum[r][c] - sum[l][c];

                if (s % 2 == 1) {
                    ++e;
                }
                s /= 2;

                m += s;
                p = (p * f[s]) % mod;
            }

            e = max(e, 1);

            println(((e * f[m]) % mod) * inv(p) % mod);

        }

    }

    public static boolean nextPermutation(int[] permutation) {
        int n = permutation.length, a = n - 2;
        while (0 <= a && permutation[a] >= permutation[a + 1]) {
            a--;
        }
        if (a == -1) {
            return false;
        }

        int b = n - 1;
        while (permutation[b] <= permutation[a]) {
            b--;
        }

        swap(permutation, a, b);
        for (int i = a + 1, j = n - 1; i < j; i++, j--) {
            swap(permutation, i, j);
        }
        return true;
    }

    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        array[i] ^= array[j];
        array[j] ^= array[i];
        array[i] ^= array[j];
    }

    int[][] nextMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = nextInt();
        return matrix;
    }

    String next() {
        while (!tokenizer.hasMoreTokens())
            tokenizer = new StringTokenizer(nextLine());
        return tokenizer.nextToken();
    }

    boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String line = nextLine();
            if (line == null) {
                return false;
            }
            tokenizer = new StringTokenizer(line);
        }
        return true;
    }

    int[] nextArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        try {
            return reader.readLine();
        } catch (IOException err) {
            return null;
        }
    }

    public Palindromes(OutputStream outputStream) {
        super(outputStream);
    }

    static BufferedReader reader;
    static StringTokenizer tokenizer = new StringTokenizer("");
    static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        Palindromes solution = new Palindromes(System.out);

        solution.run();
        solution.close();
        reader.close();
    }
}