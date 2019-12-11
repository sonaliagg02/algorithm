public class Insertion {

    private static int insertionSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        return mergeSort(arr, left, right);
    }

    private static int mergeSort(int[] array, int left, int right) {
        int count = 0;
        if (left < right){
            int mid = (left + right) / 2;
            count += mergeSort(array, left, mid);
            count += mergeSort(array, mid + 1, right);
            count += merge(array, left, mid, right);
        }
        return count;
    }

    private static long merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int count = 0;
        long total = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[count] = array[i];
                count++;
                i++;
            }else {
                total += mid + 1 - i;
                temp[count] = array[j];
                count++;
                j++;
            }
        }
        while (i <= mid){
            temp[count] = array[i];
            count++;
            i++;
        }
        while (j <= right){
            temp[count] = array[j];
            count++;
            j++;
        }

        for (i = 0; i < temp.length; i++){
            array[left + i] = temp[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 1, 2};
        System.out.println(insertionSort(arr));
    }
}
