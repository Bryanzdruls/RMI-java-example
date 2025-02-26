package Service;

import java.io.Serializable;

public class MatrixWrapper implements Serializable {
    private static final long serialVersionUID = 1L;
    private int[][] matrix;

    public MatrixWrapper(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }
    public int getMatrixIndex(int i, int j) {
        return matrix[i][j];
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}