import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FraudulentActivity {

    private static int activityNotifications(int[] expenditure, int d) {
        int noticeCount = 0;
        List<Integer> listTest = new ArrayList<>();
        int count = 0;
        for(int a = 0; a < d; a++){
            listTest.add(expenditure[a]);
            count++;
        }
        double median = findMedian(listTest);
        if (expenditure[count] >= 2 * median) {
            noticeCount++;
        }

        for(int b = d; b < expenditure.length; b++){
            listTest.remove(0);
            listTest.add(expenditure[b]);
            count++;
            if(count < expenditure.length) {
                if (expenditure[count] >= 2 * findMedian(listTest)) {
                    noticeCount++;
                }
            }
        }
        return noticeCount;
    }

    private static double findMedian(List<Integer> list){
        double median = 0;
        Collections.sort(list);
        int size = list.size();
        if(size % 2 == 0){
            double element1 = list.get(size / 2);
            double element2 = list.get((size / 2) - 1);
            median = (element1 + element2)/2;
        }else{
            median = list.get(size / 2);
        }
        return median;
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        int noticeDays = activityNotifications(input, 5);
        System.out.println(noticeDays);
    }
}