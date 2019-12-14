
import java.util.*;
import java.lang.*;
/* Name of the class has to be "Main" only if the class is public. */
class HardestSum
{

    public static void main (String[] args)
    {
        // your code goes here
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for(int test = 1; test <= T; test++) {

            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int[][] m =  new int[N][M];

            for(int row = 0; row < N; row++) {
                for(int col = 0; col < M; col++) {
                    m[row][col] = scanner.nextInt();
                }
            }

            System.out.println(findHardestSum(N, M, m));
        }
    }

    private static Long findHardestSum(int N, int M, int[][] m) {

        long[][] lft = new long[N][M];
        long[][] rit = new long[N][M];
        long[][] top = new long[N][M];
        long[][] bot = new long[N][M];

        for(int i = 0; i < N; i++) {
            rit[i][0] = m[i][0];
        }

        int r = 0;
        while(r < N) {
            for(int col = 1; col < M; col++) {
                rit[r][col] = Math.min(m[r][col], m[r][col]+rit[r][col-1]);
            }
            r++;
        }


        for(int i = 0; i < N; i++) {
            lft[i][M-1] = m[i][M-1];
        }

        r = 0;
        while(r < N) {
            for(int col = M-2; col >= 0; col--) {
                lft[r][col] = Math.min(m[r][col], m[r][col] + lft[r][col+1]);
            }
            r++;
        }


        for(int i = 0; i < M; i++) {
            bot[0][i] = m[0][i];
        }

        int c = 0;
        while(c < M) {
            for(r = 1; r < N; r++) {
                bot[r][c] = Math.min(m[r][c], m[r][c] + bot[r-1][c]);
            }
            c++;
        }


        for(int i = 0; i < M; i++) {
            top[N-1][i] = m[N-1][i];
        }

        c = 0;
        while(c < M) {
            for(r = N-2; r >= 0; r--) {
                top[r][c] = Math.min(m[r][c], m[r][c] + top[r+1][c]);
            }
            c++;
        }

        long min = Long.MAX_VALUE;

        for(r = 0; r < N; r++) {
            for(c = 0; c < M; c++) {
                long cur = lft[r][c] + rit[r][c] + bot[r][c] + top[r][c] - 3*m[r][c];
                if(cur < min) {
                    min = cur;
                }
            }
        }

        return min;
    }

}