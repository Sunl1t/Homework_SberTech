package third;

public class Matrix {
    private final double[][] data;
    private final int rows;
    private final int cols;
    private static final String EXCEPTION_ONE = "Матрицы должны быть одинакового размера для сложения";
    private static final String EXCEPTION_TWO = "Матрицы не могут быть перемножены из-за несовместимых размеров";

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    public void setValue(int i, int j, double value) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            data[i][j] = value;
        }
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
           System.out.println(EXCEPTION_ONE);
        }
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(double scalar) {
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
           System.out.println(EXCEPTION_TWO);
        }
        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    public void print() {
        for (double[] row : data) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}



