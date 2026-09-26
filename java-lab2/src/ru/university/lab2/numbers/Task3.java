package ru.university.lab2.numbers;

public class Task3 {

    public void run() {
        subtask1();
        subtask2();
        subtask3();
        subtask4();
    }

    // 1. Операторы &, |, ^, ~, <<, >>, >>>
    private void subtask1() {
        System.out.println("=== Подзадача 1: Побитовые операторы ===");
        int a = 0b1010; // 10
        int b = 0b1100; // 12

        System.out.println("a = " + a + " (binary: " + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + " (binary: " + Integer.toBinaryString(b) + ")");

        // & (AND): бит = 1 только если оба бита = 1
        System.out.println("a & b  = " + (a & b) + " (binary: " + Integer.toBinaryString(a & b) + ")");
        // 1010 & 1100 = 1000 = 8

        // | (OR): бит = 1 если хотя бы один бит = 1
        System.out.println("a | b  = " + (a | b) + " (binary: " + Integer.toBinaryString(a | b) + ")");
        // 1010 | 1100 = 1110 = 14

        // ^ (XOR): бит = 1 если биты различны
        System.out.println("a ^ b  = " + (a ^ b) + " (binary: " + Integer.toBinaryString(a ^ b) + ")");
        // 1010 ^ 1100 = 0110 = 6

        // ~ (NOT): инвертирует все биты
        System.out.println("~a     = " + (~a) + " (binary: " + Integer.toBinaryString(~a) + ")");
        // ~10 = -11 (дополнительный код)

        // << (сдвиг влево): умножение на 2^n
        System.out.println("a << 2 = " + (a << 2) + " (binary: " + Integer.toBinaryString(a << 2) + ")");
        // 1010 << 2 = 101000 = 40 (10 * 4)

        // >> (арифметический сдвиг вправо): деление на 2^n с сохранением знака
        System.out.println("a >> 1 = " + (a >> 1) + " (binary: " + Integer.toBinaryString(a >> 1) + ")");
        // 1010 >> 1 = 0101 = 5 (10 / 2)

        // >>> (логический сдвиг вправо): заполняет нулями слева
        System.out.println("a >>> 1 = " + (a >>> 1) + " (binary: " + Integer.toBinaryString(a >>> 1) + ")");
        System.out.println();
    }

    // 2. Разница между >> и >>> на отрицательных числах
    private void subtask2() {
        System.out.println("=== Подзадача 2: >> vs >>> на отрицательных ===");
        int neg = -8;
        System.out.println("neg = " + neg + " (binary: " + Integer.toBinaryString(neg) + ")");

        // >> сохраняет знаковый бит (1 заполняется слева)
        int arithShift = neg >> 2;
        System.out.println("neg >> 2  = " + arithShift + " (binary: " + Integer.toBinaryString(arithShift) + ")");
        // -8 >> 2 = -2 (арифметическое деление на 4)

        // >>> заполняет нулями слева (теряет знак)
        int logShift = neg >>> 2;
        System.out.println("neg >>> 2 = " + logShift + " (binary: " + Integer.toBinaryString(logShift) + ")");
        // -8 >>> 2 = 1073741822 (большое положительное число, т.к. знаковый бит стал 0)

        // Объяснение: >> сохраняет знак числа (арифметический сдвиг),
        // >>> всегда заполняет старшие биты нулями (логический сдвиг).
        // Для положительных чисел >> и >>> дают одинаковый результат.
        System.out.println();
    }

    // 3. Умножение/деление на степени 2 через сдвиг; подсчёт единиц
    private void subtask3() {
        System.out.println("=== Подзадача 3: Сдвиг и подсчёт битов ===");
        int num = 10;
        System.out.println("Исходное число: " + num + " (binary: " + Integer.toBinaryString(num) + ")");

        // Умножение на 2^n через сдвиг влево
        System.out.println(num + " * 2 = " + (num << 1));   // 20
        System.out.println(num + " * 4 = " + (num << 2));   // 40
        System.out.println(num + " * 8 = " + (num << 3));   // 80

        // Деление на 2^n через сдвиг вправо
        System.out.println(num + " / 2 = " + (num >> 1));   // 5
        System.out.println(num + " / 4 = " + (num >> 2));   // 2

        // Подсчёт количества единиц в двоичном представлении
        int count = 0;
        int temp = num;
        while (temp != 0) {
            count += (temp & 1); // проверяем младший бит
            temp >>>= 1;         // логический сдвиг вправо
        }
        System.out.println("Количество единиц в " + num + " (binary: " + Integer.toBinaryString(num) + ") = " + count);
        System.out.println();
    }

    // 4. Обмен значений двух переменных без временной переменной
    private void subtask4() {
        System.out.println("=== Подзадача 4: Обмен без временной переменной ===");
        int x = 5;
        int y = 10;
        System.out.println("До обмена: x = " + x + ", y = " + y);

        // Обмен через XOR
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println("После обмена (XOR): x = " + x + ", y = " + y);

        // Альтернатива: через арифметику
        int a = 7;
        int b = 3;
        System.out.println("До обмена: a = " + a + ", b = " + b);
        a = a + b;  // a = 10
        b = a - b;  // b = 7
        a = a - b;  // a = 3
        System.out.println("После обмена (арифметика): a = " + a + ", b = " + b);
        System.out.println();
    }
}