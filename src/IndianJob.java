public class IndianJob {

    private static int[][] dp = new int[101][10001];
    private static int[] timeArray = new int[101];

    static String indianJob(int g, int[] arr) {
        int n = arr.length;
        int sum = 0;
        dp[0][0] = 1;

        for(int i = 0; i < n; i++){
            timeArray[i] = arr[i];
            sum += timeArray[i];
        }

        for(int j = 0; j < 10001; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i ++){
            System.arraycopy(dp[i - 1], 0, dp[i], 0, 10001);
            for(int j = 0; j < 10001; j ++){
                if(j - timeArray[i] >= 0 ) {
                    dp[i][j] |= dp[i - 1][j - timeArray [i]];
                }
            }
        }
        boolean result = false;
        int j = 0;
        while(j <= sum){
            if(j <= g && dp[n][j] == 1 && sum - j <= g){
                result = true;
                break;
            }
            j++;
        }

        if(result){
            return "YES";
        }else{
            return "NO";
        }
    }
}
