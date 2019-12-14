import java.util.*;

public class Ashton {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int nTCs = sc.nextInt();

        String str = "";
        int k;

        for(int i=0; i< nTCs; i++){

            str = sc.next();
            k = sc.nextInt();

            System.out.println( verify(str,k));
        }
    }


    public static char verify(String str, int k){

        SuffixArray suffix = new SuffixArray(str);

        int len = suffix.length();

        int count = 0;
        char character = '$';

        int si, ei;

        boolean flag = false;

        for(int idx=0; idx<len; idx++ ){

            si = (idx==0)? idx : suffix.lcp(idx);
            ei = suffix.select(idx).length();

            for(int j=si+1; j<=ei; j++){

                if(count < k) {
                    count = count+j;
                }
                if(count >= k) {
                    character = suffix.select(idx).charAt(k -(count-j)-1);
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        return character;
    }
}

class SuffixArray {
    private Suffix[] suffixes;

    public SuffixArray(String text) {

        int N = text.length();
        this.suffixes = new Suffix[N];

        for (int i = 0; i < N; i++)
            suffixes[i] = new Suffix(text, i);

        Arrays.sort(suffixes);
    }

    public int length() {
        return suffixes.length;
    }

    public int lcp(int i) {
        if (i < 1 || i >= suffixes.length) throw new IndexOutOfBoundsException();
        return lcp(suffixes[i], suffixes[i-1]);
    }

    private static int lcp(Suffix s, Suffix t) {

        int N = Math.min(s.length(), t.length());

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) != t.charAt(i)) return i;
        }
        return N;
    }

    public String select(int i) {
        if (i < 0 || i >= suffixes.length) throw new IndexOutOfBoundsException();
        return suffixes[i].toString();
    }

    private static class Suffix implements Comparable<Suffix> {
        private final String text;
        private final int index;

        private Suffix(String text, int index) {
            this.text = text;
            this.index = index;
        }
        private int length() {
            return text.length() - index;
        }
        private char charAt(int i) {
            return text.charAt(index + i);
        }

        public int compareTo(Suffix that) {
            if (this == that) return 0;
            int N = Math.min(this.length(), that.length());
            for (int i = 0; i < N; i++) {
                if (this.charAt(i) < that.charAt(i)) return -1;
                if (this.charAt(i) > that.charAt(i)) return +1;
            }
            return this.length() - that.length();
        }

        public String toString() {
            return text.substring(index);
        }

    }
}