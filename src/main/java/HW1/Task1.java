package HW1;

import java.io.PrintStream;
import java.util.Scanner;

public class Task1 {
    public Task1() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int number1 = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int number2 = scanner.nextInt();
        PrintStream var10000 = System.out;
        int var10001 = divide(number1, number2);
        var10000.println("Результат деления: " + var10001);
        scanner.close();
    }

    public static int divide(int number1, int number2) {
        if (number2 == 0) {
            throw new ArithmeticException("Деление на ноль не допустимо");
        } else {
            return number1 / number2;
        }
    }
}
