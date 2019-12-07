import java.util.ArrayList;
import java.util.List;

public class CoinChange {

    private static long getWays(int n, List<Long> c) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (long coin : c) {
            for (long i = coin; i < n + 1; i++) {
                dp[(int)i] += dp[(int)(i - coin)];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        List<Long> denominations = new ArrayList<>();
        denominations.add((long) 1);
        denominations.add((long) 2);
        denominations.add((long) 3);
        denominations.add((long) 8);

        long num = getWays(n, denominations);
        System.out.println(num);
    }
}
