import java.io.*;
import java.util.regex.*;

public class Superman {

    private static long maxSaved(int[][] houses, int N, int H, int I){
        long[][] dp = new long[H + 1][N];
        for (int a = 0; a < H; a++) {
            long max = 0;
            if (I < a || I == a) {
                for (int b = 0; b < N; b++) {
                    max = Math.max(dp[a - I][b], max);
                }
            }
            for (int n = 0; n < N; n++) {
                long result = dp[a][n];
                dp[a + 1][n] = houses[n][a] + Math.max(max, result);
            }
        }
        long result = 0;
        for (long m: dp[H]) {
            result = Math.max(m, result);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        Pattern p = Pattern.compile("\\s+");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] array = p.split(reader.readLine());
            int building = Integer.parseInt(array[0]);
            int height = Integer.parseInt(array[1]);
            int I = Integer.parseInt(array[2]) - 1;

            int[][] houses = new int[building][height];
            for (int i = 0; i < building; i++) {
                array = p.split(reader.readLine());
                for (int j = 1; j < array.length; j++) {
                    int floor = Integer.parseInt(array[j]);
                    houses[i][floor - 1] = houses[i][floor - 1] + 1;
                }
            }
            long result = maxSaved(houses, building, height, I);
            System.out.println(result);
        }
    }
}

