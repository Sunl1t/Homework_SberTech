package third;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(2, 2);
        matrix1.setValue(0, 0, 1);
        matrix1.setValue(0, 1, 2);
        matrix1.setValue(1, 0, 3);
        matrix1.setValue(1, 1, 4);

        Matrix matrix2 = new Matrix(2, 2);
        matrix2.setValue(0, 0, 5);
        matrix2.setValue(0, 1, 6);
        matrix2.setValue(1, 0, 7);
        matrix2.setValue(1, 1, 8);

        Matrix sum = matrix1.add(matrix2);
        Matrix product = matrix1.multiply(matrix2);
        Matrix scalarProduct = matrix1.multiply(2);

        System.out.println("Матрица 1:");
        matrix1.print();

        System.out.println("Матрица 2:");
        matrix2.print();

        System.out.println("Сумма матриц:");
        sum.print();

        System.out.println("Произведение матриц:");
        product.print();

        System.out.println("Скалярное произведение матриц:");
        scalarProduct.print();
    }
}
