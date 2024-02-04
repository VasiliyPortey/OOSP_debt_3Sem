import java.util.ArrayList;

public class MatrixManager {
    private ArrayList<Matrix> matrixList = new ArrayList<>();

    public int getSize(){ return matrixList.size(); }

    public void addMatrix(int size, int min, int max){
        matrixList.add(new Matrix(size, min, max));
    }

    public void printMatrix(int index){
        try {
            System.out.println(matrixList.get(index));
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("There isn't matrix with this index");
        }
    }

    public void printMatrixCount(){ System.out.println("There is ".concat(String.valueOf(matrixList.size() + 1)).concat(" matrix")); }

    public void printLine(int matrixIndex, int lineIndex){
        try {
            StringBuilder sb = new StringBuilder("");
            int[] line = matrixList.get(matrixIndex).getLine(lineIndex);
            for (int i = 0; i < line.length; i++)
                sb.append(String.valueOf(line[i]).concat(" "));
            System.out.println(sb);
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("Invalid index!");
        }
    }

    public void printColumn(int matrixIndex, int columnIndex){
        try {
            StringBuilder sb = new StringBuilder("");
            int[] line = matrixList.get(matrixIndex).getColumn(columnIndex);
            for (int i = 0; i < line.length; i++)
                sb.append(String.valueOf(line[i]).concat(" "));
            System.out.println(sb);
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("Invalid index!");
        }
    }

    public void printMainDiagonal(int matrixIndex){
        try {
            StringBuilder sb = new StringBuilder("");
            int[] line = matrixList.get(matrixIndex).getMainDiagonal();
            for (int i = 0; i < line.length; i++)
                sb.append(String.valueOf(line[i]).concat(" "));
            System.out.println(sb);
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("Invalid index!");
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void printSideDiagonal(int matrixIndex){
        try {
            StringBuilder sb = new StringBuilder("");
            int[] line = matrixList.get(matrixIndex).getSideDiagonal();
            for (int i = 0; i < line.length; i++)
                sb.append(String.valueOf(line[i]).concat(" "));
            System.out.println(sb);
        }
        catch (IndexOutOfBoundsException exception){
            System.out.println("Invalid index!");
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void printSum(int firstIndex, int secondIndex){
        try {
            if (matrixList.get(firstIndex).getSize()!=matrixList.get(secondIndex).getSize()) {
                System.out.println("Addition isn't possible because the matrix sizes aren't equal");
                return;
            }
            for (int i = 0; i < matrixList.get(firstIndex).getSize(); i++){
                for (int j = 0; j < matrixList.get(firstIndex).getSize(); j++)
                    System.out.print(String.valueOf(matrixList.get(firstIndex).get(i,j)+matrixList.get(secondIndex).get(i,j)).concat(" "));
                System.out.println();
            }
        }
        catch (IndexOutOfBoundsException exception) {
            System.out.println("InvalidIndex!");
        }
    }

    public void printSubtraction(int firstIndex, int secondIndex){
        try {
            if (matrixList.get(firstIndex).getSize()!=matrixList.get(secondIndex).getSize()) {
                System.out.println("Subtraction isn't possible because the matrix sizes aren't equal");
                return;
            }
            for (int i = 0; i < matrixList.get(firstIndex).getSize(); i++){
                for (int j = 0; j < matrixList.get(firstIndex).getSize(); j++)
                    System.out.print(String.valueOf(matrixList.get(firstIndex).get(i,j)-matrixList.get(secondIndex).get(i,j)).concat(" "));
                System.out.println();
            }
        }
        catch (IndexOutOfBoundsException exception) {
            System.out.println("InvalidIndex!");
        }
    }

    public void printMult(int firstIndex, int secondIndex){
        try {
            if (matrixList.get(firstIndex).getSize()!=matrixList.get(secondIndex).getSize()) {
                System.out.println("Multiplication isn't possible because the matrix sizes aren't equal");
                return;
            }
            for (int i = 0; i < matrixList.get(firstIndex).getSize(); i++){
                for (int j = 0; j < matrixList.get(firstIndex).getSize(); j++) {
                    int result = 0;
                    for (int k = 0; k < matrixList.get(firstIndex).getSize(); k++)
                        result+=matrixList.get(firstIndex).get(k,i)*matrixList.get(secondIndex).get(j,k);
                    System.out.print(String.valueOf(result).concat(" "));
                }
                System.out.println();
            }
        }
        catch (IndexOutOfBoundsException exception) {
            System.out.println("InvalidIndex!");
        }
    }

}
