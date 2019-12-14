import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Interval {
    int n;
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class IntervalSelection {

    static boolean intersect(int l, Interval interval) {
        return (l >= interval.start && l <= interval.end);
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int test = in.nextInt();

        for (int t = 0; t < test; t++) {

            int N = in.nextInt();
            Interval I[] = new Interval[N];

            for (int i = 0; i < N; i++) {

                int startTime = in.nextInt();
                int endTime = in.nextInt();

                I[i] = new Interval(startTime, endTime);
            }
            Arrays.sort(I, (i1, i2) -> {
                if (i1.start == i2.start) {
                    return i2.end - i1.end;
                }
                return i1.start - i2.start;
            });

            int result = N;

            for (int i = 0; i < N; ++i) {
                if (I[i] == null) {
                    continue;
                }
                ArrayList<Interval> intersect = new ArrayList<>();

                for (int j = 0; j < N; ++j) {
                    if (I[j] != null && intersect(I[i].start, I[j])) {
                        I[j].n = j;
                        intersect.add(I[j]);
                    }
                }
                if (intersect.size() > 2) {
                    Collections.sort(intersect, new Comparator<Interval>() {
                        @Override
                        public int compare(Interval i1, Interval i2) {
                            if (i1.end == i2.end) {
                                return i2.start - i1.start;
                            }
                            return i1.end - i2.end;
                        }
                    });
                    for (int j = intersect.size() - 1; j >= 2; --j) {
                        Interval remove = intersect.get(j);
                        I[remove.n] = null;
                        result--;
                        if (remove.n == i) {
                            break;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}