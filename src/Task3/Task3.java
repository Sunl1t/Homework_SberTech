package task3;

public class Task3 {

        public static boolean prime(int num) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            for (int i = 2; i <= 100; i++) {
                if (prime(i)) {
                    System.out.print(i + " ");
                }
            }
        }


    }

