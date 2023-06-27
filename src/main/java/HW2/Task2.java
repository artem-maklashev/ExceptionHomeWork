package HW2;

import java.util.Scanner;

/*
Задача 2:
Напишите программу, которая запрашивает у пользователя два числа и выполняет их деление.
Если второе число равно нулю, программа должна выбрасывать исключение DivisionByZeroException
с сообщением "Деление на ноль недопустимо".
В противном случае, программа должна выводить результат деления.
 */
public class Task2 {
    public static void main(String[] args) {
        float number1 = inputFloat("Введите первое число: ");
        float number2 = inputFloat("Введите второе число: ");
        try {
            divideNumbers(number1, number2);
        } catch (DivisionByZeroException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static float inputFloat(String message) {
        Scanner scanner = new Scanner(System.in);
        float result;
        System.out.println(message);
        while (true) {
            if (scanner.hasNextFloat()) {
                result = scanner.nextFloat();
                return result;
            } else {
                scanner.next();
                System.out.println(message);
            }
        }
    }

    public static void divideNumbers(float value1, float value2) throws DivisionByZeroException {
        if(value2 == 0){
            throw new DivisionByZeroException("Деление на ноль недопустимо");
        } else System.out.println("Результат = " + value1/value2);
    }
}

class DivisionByZeroException extends Exception{
    public DivisionByZeroException(String message){
        super(message);
    }
}