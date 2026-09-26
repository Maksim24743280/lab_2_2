package ru.university.lab2.arrays;

public class Task6 {

    public void run() {
        subtask1();
        subtask2();
        subtask3();
    }

    // 1. Матрица 3x3, заполнение и вывод в виде таблицы
    private void subtask1() {
        System.out.println("=== Подзадача 1: Матрица 3x3 ===");
        int[][] matrix = new int[3][3];
        int counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = counter++;
            }
        }
        printMatrix(matrix);
        System.out.println();
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // 2. Транспонирование матрицы
    private void subtask2() {
        System.out.println("=== Подзадача 2: Транспонирование ===");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Исходная матрица:");
        printMatrix(matrix);

        int[][] transposed = transpose(matrix);
        System.out.println("Транспонированная:");
        printMatrix(transposed);
        System.out.println();
    }

    private int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // 3. Умножение матриц с проверкой размерностей
    private void subtask3() {
        System.out.println("=== Подзадача 3: Умножение матриц ===");
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        }; // 2x3

        int[][] b = {
                {7, 8},
                {9, 10},
                {11, 12}
        }; // 3x2

        System.out.println("Матрица A (2x3):");
        printMatrix(a);
        System.out.println("Матрица B (3x2):");
        printMatrix(b);

        int[][] result = multiplyMatrices(a, b);
        if (result != null) {
            System.out.println("A * B =");
            printMatrix(result);
        } else {
            System.out.println("Умножение невозможно: несовместимые размерности");
        }

        // Проверка с несовместимыми размерностями
        int[][] c = {
                {1, 2},
                {3, 4}
        }; // 2x2
        int[][] d = {
                {1, 2, 3}
        }; // 1x3
        System.out.println("\nМатрица C (2x2) * D (1x3):");
        int[][] badResult = multiplyMatrices(c, d);
        if (badResult == null) {
            System.out.println("Результат: null (размерности не совпадают: 2 != 1)");
        }
        System.out.println();
    }

    private int[][] multiplyMatrices(int[][] a, int[][] b) {
        int aRows = a.length;
        int aCols = a[0].length;
        int bRows = b.length;
        int bCols = b[0].length;

        // Проверка: количество столбцов A должно равняться количеству строк B
        if (aCols != bRows) {
            return null; // размерности не совпадают
        }

        int[][] result = new int[aRows][bCols];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                int sum = 0;
                for (int k = 0; k < aCols; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}