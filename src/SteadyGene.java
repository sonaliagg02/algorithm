import java.util.HashMap;
import java.util.Map;

public class SteadyGene {

    private static Map<Character, Integer> map = new HashMap<>();

    private static void init(){
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);
    }

    private static int steadyGene(String s) {
        init();
        int target = s.length()/4;
        int start = 0, end = 0;
        int n = s.length();
        int best = s.length();
        char[] charArray = s.toCharArray();
        for (char c : charArray){
            map.put(c, map.get(c) + 1);
        }
        while (end <= n && start < n) {
            if (map.get('A') <= target && map.get('C') <= target && map.get('G') <= target && map.get('T') <= target) {
                best = Math.min(best, end - start);
                map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                start++;
            } else {
                if (end < n) {
                    map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                }
                end++;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        String gene = "GAAATAAA";
        System.out.println(steadyGene(gene));
    }
}
