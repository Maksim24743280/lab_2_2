package ru.university.lab2.strings;

public class Task4 {

    public void run() {
        subtask1();
        subtask2();
        subtask3();
        subtask4();
        subtask5();
    }

    // 1. Проверка палиндрома (регистр и пробелы игнорируются)
    private void subtask1() {
        System.out.println("=== Подзадача 1: Палиндром ===");
        String[] tests = {
                "А роза упала на лапу Азора",
                "шалаш",
                "Привет мир",
                "Аргентина манит негра",
                "12321"
        };
        for (String s : tests) {
            System.out.println("\"" + s + "\" — палиндром? " + isPalindrome(s));
        }
        System.out.println();
    }

    private boolean isPalindrome(String s) {
        // Удаляем пробелы и приводим к нижнему регистру
        String cleaned = s.replaceAll(" ", "").toLowerCase();
        char[] chars = cleaned.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    // 2. Разворот порядка слов в предложении
    private void subtask2() {
        System.out.println("=== Подзадача 2: Разворот слов ===");
        String sentence = "Java это мощный язык программирования";
        System.out.println("Исходная строка: \"" + sentence + "\"");

        // Разбиваем по пробелам вручную (без split, т.к. работаем с char[])
        // Но split допустим — он возвращает String[], не коллекцию
        String[] words = sentence.split(" ");

        // Разворот массива слов
        for (int i = 0; i < words.length / 2; i++) {
            String tmp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = tmp;
        }

        // Собираем обратно
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) sb.append(" ");
        }
        String reversed = sb.toString();
        System.out.println("Развёрнутая: \"" + reversed + "\"");

        // Длина каждого слова
        System.out.println("Длины слов:");
        for (String w : words) {
            System.out.println("  \"" + w + "\" — " + w.length() + " символов");
        }
        System.out.println();
    }

    // 3. Подсчёт гласных, согласных, цифр и пробелов
    private void subtask3() {
        System.out.println("=== Подзадача 3: Подсчёт символов ===");
        String text = "Hello World 123! Привет 456";
        System.out.println("Текст: \"" + text + "\"");

        int vowels = 0, consonants = 0, digits = 0, spaces = 0;
        char[] chars = text.toCharArray();

        for (char c : chars) {
            char lower = Character.toLowerCase(c);
            if (c == ' ') {
                spaces++;
            } else if (c >= '0' && c <= '9') {
                digits++;
            } else if (isLatinLetter(c)) {
                if (lower == 'a' || lower == 'e' || lower == 'i' ||
                        lower == 'o' || lower == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else if (isCyrillicLetter(c)) {
                char cl = Character.toLowerCase(c);
                if (cl == 'а' || cl == 'е' || cl == 'и' || cl == 'о' ||
                        cl == 'у' || cl == 'ы' || cl == 'э' || cl == 'ю' || cl == 'я') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Гласные: " + vowels);
        System.out.println("Согласные: " + consonants);
        System.out.println("Цифры: " + digits);
        System.out.println("Пробелы: " + spaces);
        System.out.println();
    }

    private boolean isLatinLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isCyrillicLetter(char c) {
        return (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') || c == 'ё' || c == 'Ё';
    }

    // 4. Шифр Цезаря (только латинские буквы, регистр сохраняется)
    private void subtask4() {
        System.out.println("=== Подзадача 4: Шифр Цезаря ===");
        String original = "Hello World! Java 2024";
        int shift = 3;
        System.out.println("Исходный текст: \"" + original + "\"");
        System.out.println("Сдвиг: " + shift);

        String encrypted = caesarEncrypt(original, shift);
        System.out.println("Зашифрованный: \"" + encrypted + "\"");

        String decrypted = caesarDecrypt(encrypted, shift);
        System.out.println("Расшифрованный: \"" + decrypted + "\"");
        System.out.println();
    }

    private String caesarEncrypt(String text, int shift) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftChar(chars[i], shift);
        }
        return new String(chars);
    }

    private String caesarDecrypt(String text, int shift) {
        return caesarEncrypt(text, 26 - (shift % 26));
    }

    private char shiftChar(char c, int shift) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('a' + (c - 'a' + shift) % 26);
        } else if (c >= 'A' && c <= 'Z') {
            return (char) ('A' + (c - 'A' + shift) % 26);
        }
        return c; // не латинская буква — не меняем
    }

    // 5. Поиск самого длинного слова в строке
    private void subtask5() {
        System.out.println("=== Подзадача 5: Самое длинное слово ===");
        String text = "Java программирование язык мощный очень";
        System.out.println("Текст: \"" + text + "\"");

        String[] words = text.split(" ");
        String longest = words[0];
        for (String w : words) {
            if (w.length() > longest.length()) {
                longest = w;
            }
        }
        System.out.println("Самое длинное слово: \"" + longest + "\" (длина: " + longest.length() + ")");
        System.out.println();
    }
}