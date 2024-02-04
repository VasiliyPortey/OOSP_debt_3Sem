import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Scanner sc;
    MatrixManager mm;
    int min, max;

    public Menu(){
        mm = new MatrixManager();
        sc = new Scanner(System.in);
        System.out.print("Введите нижнюю границу для генерации рандомных чисел: ");
        setMin();
        System.out.print("\nВведите верхнюю границу для генерации рандомных чисел: ");
        setMax();
        menu();
    }

    private void setMin(){
        try {
            min = sc.nextInt();
        }
        catch (InputMismatchException exception){
            System.out.println("Некорректный ввод! Попробуйте снова...");
            sc.nextLine();
            setMin();
        }
    }

    private void setMax(){
        try {
            max = sc.nextInt();
            if (max<=min){
                System.out.println("Верхняя граница должна быть больше нижней! Попробуйте снова...");
                setMax();
            }
        }
        catch (InputMismatchException exception){
            System.out.println("Некорректный ввод! Попробуйте снова...");
            setMin();
        }
    }

    private void menu(){
        int choice = 0;
        while (choice != 10){
            System.out.println("\n\nВыберите действие:");
            System.out.println("0. Добавить матрицу");
            System.out.println("1. Вывести матрицу в консоль");
            System.out.println("2. Вывести строку матрицы");
            System.out.println("3. Вывести столбец матрицы");
            System.out.println("4. Вывести главную диагональ матрицы");
            System.out.println("5. Вывести побочную диагональ матрицы");
            System.out.println("6. Вывести на экран результат сложения двух матриц");
            System.out.println("7. Вывести на экран результат вычитания матрицы");
            System.out.println("8. Вывести на экран результат умножения двух матриц");
            System.out.println("9. Узнать количество добавленных матриц");
            System.out.println("10. Выход из приложения");
            try {
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case (0): addMatrix();
                    case (1): printMatrix();
                    case (2): printLine();
                    case (3): printColumn();
                    case (4): printMainDiagonal();
                    case (5): printSideDiagonal();
                    case (6): printSum();
                    case (7): printSubtraction();
                    case (8): printMult();
                    case (9): printSize();
                    case(10): return;
                }
            }
            catch (InputMismatchException exception){
                System.out.println("Некорректный ввод!");
                menu();
            }
        }
    }

    private void addMatrix(){
        System.out.print("Введите размерность квадратной матрицы: ");
        try {
            int size = sc.nextInt();
            if (size<2){
                System.out.println("Число введено некорректно! Введите целое число больше единицы!");
                sc.nextLine();
                addMatrix();
            }
            else {
                mm.addMatrix(size, min, max);
                System.out.println("Матрица размерности ".concat(String.valueOf(size)).concat("x").concat(String.valueOf(size)).concat(" успешно добавлена"));
                System.out.println("с индексом ".concat(String.valueOf(mm.getSize()-1)));
                sc.nextLine();
                menu();
            }
        }
        catch (InputMismatchException exception){
            System.out.println("Число введено некорректно! Введите целое число больше единицы!");
            sc.nextLine();
            addMatrix();
        }
    }

    private void printMatrix(){
        System.out.print("Введите номер матрицы для вывода ");
        try {
            int index = sc.nextInt();
            mm.printMatrix(index);
            sc.nextLine();
            menu();
        }
        catch (InputMismatchException exception){
            System.out.println("Число введено некорректно! Введите целое число от нуля и больше");
            sc.nextLine();
            menu();
        }
    }

    private void printLine(){
        System.out.print("Введите номер матрицы: ");
        try {
            int matrixIndex = sc.nextInt();
            System.out.print("Введите номер строки для вывода: ");
            int lineIndex = sc.nextInt();
            sc.nextLine();
            mm.printLine(matrixIndex, lineIndex);
            menu();
        }
        catch (InputMismatchException exception){
            System.out.println("Число введено некорректно! Введите целое число от нуля и больше");
            sc.nextLine();
            menu();
        }
    }

    private void printColumn(){
        System.out.print("Введите номер матрицы: ");
        try {
            int matrixIndex = sc.nextInt();
            System.out.print("Введите номер столбца для вывода: ");
            int columnIndex = sc.nextInt();
            sc.nextLine();
            mm.printColumn(matrixIndex, columnIndex);
            menu();
        }
        catch (InputMismatchException exception){
            System.out.println("Число введено некорректно! Введите целое число от нуля и больше");
            sc.nextLine();
            menu();
        }
    }

    private void printMainDiagonal(){
        System.out.print("Введите номер матрицы для вывода её главной диагонали: ");
        try {
            int index = sc.nextInt();
            mm.printMainDiagonal(index);
            sc.nextLine();
            menu();
        }
        catch (InputMismatchException exception){
            System.out.println("Число введено некорректно! Введите целое число от нуля и больше");
            sc.nextLine();
            menu();
        }
    }

    private void printSideDiagonal(){
        System.out.print("Введите номер матрицы для вывода её побочной диагонали: ");
        try {
            int index = sc.nextInt();
            mm.printSideDiagonal(index);
            sc.nextLine();
            menu();
        }
        catch (InputMismatchException exception){
            System.out.println("Число введено некорректно! Введите целое число от нуля и больше");
            sc.nextLine();
            menu();
        }
    }

    private void printSum(){
        System.out.print("Введите номер первой матрицы: ");
        try {
            int firstIndex = sc.nextInt();
            System.out.print("Введите номер второй матрицы: ");
            int secondIndex = sc.nextInt();
            System.out.println("Результат сложения этих матриц: ");
            mm.printSum(firstIndex, secondIndex);
            menu();
        }
        catch (InputMismatchException exception){
            System.out.println("Число введено некорректно! Введите целое число от нуля и больше");
            sc.nextLine();
            menu();
        }
    }

    private void printSubtraction(){
        System.out.print("Введите номер первой матрицы: ");
        try {
            int firstIndex = sc.nextInt();
            System.out.print("Введите номер второй матрицы: ");
            int secondIndex = sc.nextInt();
            System.out.println("Результат вычитания из ".concat(String.valueOf(firstIndex)).concat("-й матрицы ").concat(String.valueOf(secondIndex)).concat("-й матрицы: "));
            mm.printSubtraction(firstIndex, secondIndex);
            menu();
        }
        catch (InputMismatchException exception){
            System.out.println("Число введено некорректно! Введите целое число от нуля и больше");
            sc.nextLine();
            menu();
        }
    }

    private void printMult(){
        System.out.print("Введите номер первой матрицы: ");
        try {
            int firstIndex = sc.nextInt();
            System.out.print("Введите номер второй матрицы: ");
            int secondIndex = sc.nextInt();
            System.out.println("Результат умножения матриц: ");
            mm.printMult(firstIndex, secondIndex);
            menu();
        }
        catch (InputMismatchException exception){
            System.out.println("Число введено некорректно! Введите целое число от нуля и больше");
            sc.nextLine();
            menu();
        }
    }

    private void printSize(){
        System.out.println("Кличество добавленных матриц: ".concat(String.valueOf(mm.getSize())));
    }
}
