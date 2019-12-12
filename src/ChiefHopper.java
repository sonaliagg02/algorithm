public class ChiefHopper {

    private static int chiefHopper(int[] arr) {
        double newEnergy = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            newEnergy = newEnergy + arr[i];
            newEnergy = newEnergy / 2;
            newEnergy = (int) Math.ceil(newEnergy);
        }
        return (int)newEnergy;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 3, 2};
        System.out.println(chiefHopper(arr));
    }
}
