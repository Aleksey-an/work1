import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод: ");

        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    static String calc(String input) throws Exception {
        input = input.trim();

        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("throws Exception");
        }

        int a = parseNumber(parts[0]);
        String operator = parts[1];
        int b = parseNumber(parts[2]);

        switch (operator) {
            case "+":
                return Integer.toString(a + b);
            case "-":
                return Integer.toString(a - b);
            case "*":
                return Integer.toString(a * b);
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль недопустимо.");
                }
                return Integer.toString(a / b);
            default:
                throw new Exception("Неверный оператор. Доступные операторы: +, -, *, /.");
        }
    }

    static int parseNumber(String str) throws Exception {
        try {
            int number = Integer.parseInt(str);
            if (number < 1 || number > 10) {
                throw new Exception("Числа должны быть от 1 до 10 включительно.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Неверный формат числа: " + str);
        }
    }
}