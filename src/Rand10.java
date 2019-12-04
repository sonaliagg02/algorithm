public class Rand10 {

    private double rand7(){
        return (Math.random()*((7-1)+1))+1;
    }

    private double rand10(){
        while (true){
            double row = rand7();
            double col = rand7();
            double result = 7 * (row - 1) + col - 1;
            if(result < 40){
                return result % 10 + 1;
            }
        }
    }

    public static void main(String[] args) {
        Rand10 rand10 = new Rand10();
        double val = rand10.rand10();
        System.out.println(val);
    }
}
