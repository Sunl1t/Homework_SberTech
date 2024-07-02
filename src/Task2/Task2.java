package Task2;

public class Task2 {
    public static void main(String[] args) {
        int size = 10;
        double[] array = new double[size];
        double sum = 0;
        double max = 0;
        double avg = 0;
        for(int i = 0; i < size; i++) {
            array[i] = Math.random();
            sum+=array[i];
            if(array[i] > max) {
                max = array[i];
            }
        }
        avg = sum/size;
        System.out.println("Среднее значение равно " + avg);
        System.out.println("Максимальное значение равно " + max);
    }
}
