public class RotateString {

    private static boolean rotateString(String A, String B) {
        int len1 = A.length();
        int len2 = B.length();
        if(len1 != len2){
            return false;
        }
        if(A.equals("") && B.equals("")){
            return true;
        }
        int longestLen = 0;
        int[] dp = new int[len1 + 1];

        int i = 1;

        while (i < len1){
            if(B.charAt(longestLen) != A.charAt(i)){
                if(longestLen == 0){
                    dp[i] = 0;
                    i++;
                }else{
                    longestLen = dp[longestLen - 1];
                }
            }else{
                longestLen++;
                dp[i] = longestLen;
                i++;
            }
        }

        int j = 0;
        for(int a = dp[len1 - 1]; a < len1; a++){
            if(B.charAt(a) != A.charAt(j)){
                return  false;
            }
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "abacd";
        String b = "cdaba";
        System.out.println(rotateString(a, b));
    }
}
