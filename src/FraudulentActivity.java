import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FraudulentActivity {

    private static int activityNotifications(int[] expenditure, int d) {
        int noticeCount = 0;
        for(int i = 0; i < expenditure.length - (d - 1); i++){
            List<Integer> list = new ArrayList<>();
            int j = i;
            int count = 0;
            while(count < d){
                list.add(expenditure[j]);
                j++;
                count++;
            }
            double median = findMedian(list);
            if(j < expenditure.length){
                if(expenditure[j] >= 2*median){
                    noticeCount++;
                }
            }else {
                break;
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
        int[] input = {1, 2, 3, 4, 4};
        int noticeDays = activityNotifications(input, 4);
        System.out.println(noticeDays);
    }
}