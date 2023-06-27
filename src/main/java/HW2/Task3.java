/*
Напишите программу, которая запрашивает у пользователя три числа и выполняет следующие проверки:

Если первое число больше 100, выбросить исключение NumberOutOfRangeException с сообщением "Первое число вне допустимого диапазона".
Если второе число меньше 0, выбросить исключение NumberOutOfRangeException с сообщением "Второе число вне допустимого диапазона".
Если сумма первого и второго чисел меньше 10, выбросить исключение NumberSumException с сообщением "Сумма первого и второго чисел слишком мала".
Если третье число равно 0, выбросить исключение DivisionByZeroException с сообщением "Деление на ноль недопустимо".
В противном случае, программа должна выводить сообщение "Проверка пройдена успешно".
- необходимо создать 3 класса собвстенных исключений
 */

package HW2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int number1 = inputInt("Введите первое число: ");
        int number2 = inputInt("Введите второе число: ");
        int number3 = inputInt("Введите третье число: ");
        try {
            checkNumbers(number1, number2, number3);
        } catch (NumberOutOfRangeException | NumberSumException | DivisionByZeroException2 ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Integer inputInt(String message) {
        Scanner scanner = new Scanner(System.in);
        int result;
        System.out.println(message);
        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                return result;
            } else {
                scanner.next();
                System.out.println(message);
            }
        }
    }
    public static void checkNumbers(int number1, int number2, int number3) throws NumberOutOfRangeException, NumberSumException, DivisionByZeroException2 {
        if(number1>100){
            throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
        }
        if(number2<0){
            throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
        }
        if((number1+number2)<10){
            throw new NumberSumException("Сумма первого и второго числа слишеом мала");
        }
        if(number3==0){
            throw new DivisionByZeroException2("Деление на ноль недопустимо");
        }
        System.out.println("Проверка пройдена успешно");
    }
}

class NumberOutOfRangeException extends Exception{
    public NumberOutOfRangeException(String message){
        super(message);
    }
}
class NumberSumException extends Exception{
    public NumberSumException(String message){
        super(message);
    }
}
class DivisionByZeroException2 extends Exception{
    public DivisionByZeroException2(String message){
        super(message);
    }
}
