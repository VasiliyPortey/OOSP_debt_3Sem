import java.util.ArrayList;

public class Matrix {
    private int[][] matrix;
    private int size;

    public int getSize(){ return size; }

    public int get(int i, int j){ return matrix[i][j]; }

    public Matrix(int size, int min, int max){
        this.matrix = new int[size][size];
        for (int i = 0; i<size; i++)
            for (int j = 0; j<size; j++)
                this.matrix[i][j]=RandomEnterer.randomEntering(min, max);
        this.size = size;
    }

    public int[] getLine(int index){
        return matrix[index];
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i<size; i++){
            for (int j = 0; j<size; j++)
                stringBuilder.append(String.valueOf(matrix[i][j]).concat(" "));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int[] getColumn(int index){
        int[] column = new int[size];
        for (int i = 0; i<size; i++)
            column[i] = matrix[i][index];
        return column;
    }

    public int[] getMainDiagonal() throws Exception{
        if (size%2==0)
            throw new Exception("There isn't a main diagonal");
        int[] diagonal = new int[size];
        for (int i = 0; i<size; i++)
            diagonal[i] = matrix[i][i];
        return diagonal;
    }

    public int[] getSideDiagonal() throws Exception{
        if (size%2==0)
            throw new Exception("There isn't a side diagonal");
        int[] diagonal = new int[size];
        for (int i = 0; i<size; i++)
            diagonal[i] = matrix[i][size-i-1];
        return diagonal;
    }
}
