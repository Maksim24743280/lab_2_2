package ru.university.lab2.arrays;

import java.util.Arrays;

public class Task5 {

    public void run() {
        subtask1();
        subtask2();
        subtask3();
        subtask4();
    }

    // 1. Заполнение массива из 15 случайных чисел
    private void subtask1() {
        System.out.println("=== Подзадача 1: Случайный массив ===");
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100); // числа от 0 до 99
        }
        System.out.println("Массив: " + arrayToString(arr));
        System.out.println();
    }

    // 2. Аналог Arrays: min, max, среднее арифметическое
    private void subtask2() {
        System.out.println("=== Подзадача 2: Min, Max, Среднее ===");
        int[] arr = {23, 45, 12, 67, 34, 89, 2, 56, 78, 11};
        System.out.println("Массив: " + arrayToString(arr));
        System.out.println("Min: " + findMin(arr));
        System.out.println("Max: " + findMax(arr));
        System.out.println("Среднее: " + findAverage(arr));
        System.out.println();
    }

    private int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    private int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    private double findAverage(int[] arr) {
        int sum = 0;
        for (int v : arr) sum += v;
        return (double) sum / arr.length;
    }

    // 3. Сортировка выбором с выводом после каждого шага
    private void subtask3() {
        System.out.println("=== Подзадача 3: Сортировка выбором ===");
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Исходный массив: " + arrayToString(arr));

        selectionSort(arr);

        // Проверка через Arrays.sort
        int[] original = {64, 25, 12, 22, 11};
        Arrays.sort(original);
        System.out.println("Arrays.sort результат: " + arrayToString(original));
        // Комментарий: Arrays.sort использует Dual-Pivot Quicksort (O(n log n)),
        // сортировка выбором — O(n²). Arrays.sort значительно быстрее на больших массивах.
        System.out.println();
    }

    private void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Обмен
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
            System.out.println("Шаг " + (i + 1) + ": " + arrayToString(arr));
        }
    }

    // 4. Разница между arr1 = arr2, arr1.equals(arr2), Arrays.equals(arr1, arr2)
    private void subtask4() {
        System.out.println("=== Подзадача 4: Сравнение массивов ===");
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = arr1; // arr3 ссылается на тот же объект

        System.out.println("arr1 = " + arrayToString(arr1));
        System.out.println("arr2 = " + arrayToString(arr2));
        System.out.println("arr3 = arr1 (та же ссылка)");

        // arr1 = arr2 — это присваивание ссылки, arr1 теперь указывает на arr2
        // Но здесь мы просто сравниваем:
        System.out.println("arr1 == arr2 (сравнение ссылок): " + (arr1 == arr2));
        // false — разные объекты в памяти

        System.out.println("arr1 == arr3 (та же ссылка): " + (arr1 == arr3));
        // true — arr3 и arr1 указывают на один объект

        // .equals() для массивов — это наследованный метод Object, сравнивает ссылки
        System.out.println("arr1.equals(arr2): " + arr1.equals(arr2));
        // false — метод equals() у массивов не переопределён, сравнивает ссылки

        // Arrays.equals() — сравнивает содержимое поэлементно
        System.out.println("Arrays.equals(arr1, arr2): " + Arrays.equals(arr1, arr2));
        // true — содержимое одинаковое

        System.out.println();
        System.out.println("Вывод:");
        System.out.println("  arr1 = arr2 → присваивание ссылки (arr1 указывает на arr2)");
        System.out.println("  arr1.equals(arr2) → сравнение ссылок (как ==), false для разных объектов");
        System.out.println("  Arrays.equals(arr1, arr2) → поэлементное сравнение содержимого, true");
        System.out.println();
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}