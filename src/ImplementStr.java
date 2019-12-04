public class ImplementStr {

    private static final int charCount = 256;

    private int strStr(String haystack, String needle) {
        int prime = 31;
        int len1 = haystack.length();
        int len2 = needle.length();
        int needleHash = 0;
        double hayHash = 0;

        double power = Math.pow(charCount, len2 - 1);
        power = power % prime;

        for(int i = 0; i < len2; i++){
            needleHash = (charCount * needleHash + needle.charAt(i));
            needleHash = needleHash  % prime;

            hayHash = (charCount * hayHash + haystack.charAt(i));
            hayHash = hayHash  % prime;
        }

        for(int i = 0; i < len1 - len2 + 1; i++){
            if(needleHash == hayHash){
                int j;
                for(j = 0; j < len2; j++){
                    if(haystack.charAt(i + j) != needle.charAt(j)){
                        break;
                    }
                }
                if(j == len2){
                    return i;
                }
            }

            if(i < len1 - len2){
                hayHash = (charCount * (hayHash - haystack.charAt(i) * power) + haystack.charAt(i + len2));
                hayHash = hayHash % prime;

                if(hayHash < 0){
                    hayHash = hayHash + prime;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStr str = new ImplementStr();
        int index = str.strStr("aaaaa", "bba");
        System.out.println(index);
    }
}
