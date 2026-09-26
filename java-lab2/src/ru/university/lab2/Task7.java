package ru.university.lab2.numbers;

public class Task7 {

    public void run() {
        subtask1();
        subtask2();
        subtask3();
    }

    // 1. Перегруженный метод print для int, double, String, int[]
    private void subtask1() {
        System.out.println("=== Подзадача 1: Перегрузка print ===");
        print(42);
        print(3.14);
        print("Hello");
        print(new int[]{1, 2, 3, 4, 5});
        System.out.println();
    }

    private void print(int value) {
        System.out.println("[int]    " + value);
    }

    private void print(double value) {
        System.out.println("[double] " + value);
    }

    private void print(String value) {
        System.out.println("[String] " + value);
    }

    private void print(int[] arr) {
        StringBuilder sb = new StringBuilder("[int[]]  {");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("}");
        System.out.println(sb.toString());
    }

    // 2. Varargs: сумма произвольного числа аргументов
    private void subtask2() {
        System.out.println("=== Подзадача 2: Varargs ===");
        // Вызов с разным количеством аргументов
        System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3));
        System.out.println("sum(10, 20) = " + sum(10, 20));
        System.out.println("sum(5) = " + sum(5));
        System.out.println("sum() = " + sum());

        // Тот же результат через массив
        int[] arr = {1, 2, 3};
        System.out.println("sumArray({1,2,3}) = " + sumArray(arr));
        // Результат одинаковый: varargs внутри метода представляется как массив
        System.out.println();
    }

    private int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    private int sumArray(int[] numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    // 3. Обмен двух целых: через массив и через return
    private void subtask3() {
        System.out.println("=== Подзадача 3: Обмен значений ===");

        // Способ 1: через массив (передача по ссылке)
        int[] pair = {5, 10};
        System.out.println("До обмена (массив): [" + pair[0] + ", " + pair[1] + "]");
        swapViaArray(pair);
        System.out.println("После swapViaArray: [" + pair[0] + ", " + pair[1] + "]");

        // Способ 2: через return (возврат нового массива)
        int a = 7, b = 3;
        System.out.println("До обмена (return): a=" + a + ", b=" + b);
        int[] result = swapViaReturn(a, b);
        a = result[0];
        b = result[1];
        System.out.println("После swapViaReturn: a=" + a + ", b=" + b);

        // Рекурсивный вариант (медленнее, риск StackOverflow)
        System.out.println("\nРекурсивный обмен:");
        int[] recResult = swapRecursive(new int[]{20, 30}, 0);
        System.out.println("Результат: [" + recResult[0] + ", " + recResult[1] + "]");

        // Демонстрация StackOverflow при рекурсии на отрицательных числах
        // (если рекурсия не имеет корректного базового случая)
        System.out.println("\nПопытка рекурсии без базового случая (закомментировано, чтобы не упасть):");
        System.out.println("// swapBadRecursive(-1) → StackOverflowError");
        System.out.println();

        /*
         * Объяснение в комментариях:
         *
         * swapViaArray (передача по ссылке):
         *   - Массив в Java передаётся по ссылке (копия ссылки на объект).
         *   - Изменения внутри метода видны снаружи.
         *   - Работает быстро: O(1), нет создания новых объектов.
         *
         * swapViaReturn (передача по значению / возврат):
         *   - Примитивы передаются по значению (копия).
         *   - Нужно создать новый массив и вернуть его.
         *   - Медленнее: создаётся новый объект, нагрузка на GC.
         *
         * Рекурсивный вариант:
         *   - Каждый вызов добавляет фрейм в стек.
         *   - На больших данных → StackOverflowError.
         *   - Значительно медленнее итеративного варианта.
         *
         * Вывод: swapViaArray быстрее, т.к. не создаёт новых объектов
         * и работает напрямую с памятью.
         */
    }

    private void swapViaArray(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    private int[] swapViaReturn(int a, int b) {
        return new int[]{b, a};
    }

    // Рекурсивный обмен (демонстрационный)
    private int[] swapRecursive(int[] arr, int depth) {
        if (depth >= 1) {
            int tmp = arr[0];
            arr[0] = arr[1];
            arr[1] = tmp;
            return arr;
        }
        return swapRecursive(arr, depth + 1);
    }

    /*
     * Плохой рекурсивный вариант (вызовет StackOverflow):
     *
     * private int[] swapBadRecursive(int[] arr) {
     *     // Нет базового случая — бесконечная рекурсия
     *     int tmp = arr[0];
     *     arr[0] = arr[1];
     *     arr[1] = tmp;
     *     return swapBadRecursive(arr); // StackOverflowError!
     * }
     */
}