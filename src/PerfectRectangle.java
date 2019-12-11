import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {

    private static boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<>();
        for(int[] rec: rectangles){
            String bl = createCorner(rec[0], rec[1], "bl");
            String br = createCorner(rec[2], rec[1], "br");
            String tl = createCorner(rec[0], rec[3], "tl");
            String tr = createCorner(rec[2], rec[3], "tr");

            if(set.contains(bl)){
                return false;
            }else{
                set.add(bl);
            }
            if(set.contains(br) ){
                return false;
            }else{
                set.add(br);
            }
            if(set.contains(tl)){
                return false;
            }else{
                set.add(tl);
            }
            if(set.contains(tr)){
                return false;
            }else{
                set.add(tr);
            }

            String tl1 = createCorner(rec[0], rec[1], "tl");
            String br1 = createCorner(rec[0], rec[1], "br");
            if(set.remove(tl1)) {
                set.remove(bl);
            }else if(set.remove(br1)){
                set.remove(bl);
            }

            String bl1 = createCorner(rec[2], rec[1], "bl");
            String tr1 = createCorner(rec[2], rec[1], "tr");
            if(set.remove(bl1)){
                set.remove(br);
            }else if(set.remove(tr1)){
                set.remove(br);
            }

            String tr2 = createCorner(rec[0], rec[3], "tr");
            String bl2 = createCorner(rec[0], rec[3], "bl");
            if(set.remove(tr2)){
                set.remove(tl);
            }else if(set.remove(bl2)){
                set.remove(tl);
            }

            String tl2 = createCorner(rec[2], rec[3], "tl");
            String br2 = createCorner(rec[2], rec[3], "br");
            if(set.remove(tl2)){
                set.remove(tr);
            }else if(set.remove(br2)){
                set.remove(tr);
            }
        }

        if(set.size() == 4){
            return true;
        }else{
            return false;
        }
    }

    private static String createCorner(int corner1, int corner2, String name){
        return corner1 + "," + corner2 + "," + name;
    }

    public static void main(String[] args) {
        int[][] rectangle = new int[5][4];
        rectangle[0][0] = 1;
        rectangle[0][1] = 1;
        rectangle[0][2] = 3;
        rectangle[0][3] = 3;

        rectangle[1][0] = 3;
        rectangle[1][1] = 1;
        rectangle[1][2] = 4;
        rectangle[1][3] = 2;

        rectangle[2][0] = 3;
        rectangle[2][1] = 2;
        rectangle[2][2] = 4;
        rectangle[2][3] = 4;

        rectangle[3][0] = 1;
        rectangle[3][1] = 3;
        rectangle[3][2] = 2;
        rectangle[3][3] = 4;

        rectangle[4][0] = 2;
        rectangle[4][1] = 3;
        rectangle[4][2] = 3;
        rectangle[4][3] = 4;

        System.out.println(isRectangleCover(rectangle));
    }
}
