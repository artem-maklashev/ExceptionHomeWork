package HW3;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Напишите программу-калькулятор, которая запрашивает у пользователя два числа и выполняет операцию возведения первого
числа в степень второго числа.
Если введены некорректные числа или происходит деление на ноль, необходимо обработать соответствующие исключения и
вывести информативное сообщение об ошибке.
Важно! С использованием принципа одного уровня абстракции!
**В этой задаче мы создаем класс PowerCalculator, который содержит метод calculatePower(),
выполняющий операцию возведения числа в степень. Если введено некорректное основание (ноль) и отрицательная степень,
выбрасывается исключение InvalidInputException.
 */
public class PowerCalculator {
    public static void main(String[] args) throws IOException {
        try ( Scanner scanner = new Scanner(System.in);) {
            double firstNumber = getDoubleNumber(scanner, "ведите первое число: ");
            double secondNumber = getDoubleNumber(scanner, "ведите второе число: ");
            double result = calculatePower(firstNumber, secondNumber);
            System.out.println(result);
        } catch (InvalidInputException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static double calculatePower(double firstNumber, double secondNumber) throws InvalidInputException {
        if (secondNumber < 0)
            throw new InvalidInputException("Некорректное второе число. Второе число не может быть отрицательным");
        if (firstNumber == 0) throw new InvalidInputException("Первое число не может быть 0");
        return Math.pow(firstNumber, secondNumber);
    }

    private static double getDoubleNumber(Scanner scanner, String s) {
        double number;
        while (true) {
            try {
                System.out.println(s);
                number = scanner.nextDouble();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Введено некорректоное число. Повторите ввод.");
                scanner.next();
            }
        }
        return number;
    }

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}
