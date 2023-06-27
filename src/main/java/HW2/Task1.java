package HW2;/*
Задача 1:
Напишите программу, которая запрашивает у пользователя число и проверяет, является ли оно положительным.
Если число отрицательное или равно нулю, программа должна выбрасывать исключение InvalidNumberException
с сообщением "Некорректное число".
В противном случае, программа должна выводить сообщение "Число корректно".
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int number = inputInt();
        try {
            checkNumber(number);
        } catch (InvalidNumberException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void checkNumber(int value) throws InvalidNumberException{
        if(value<=0){
            throw new InvalidNumberException("Некорректное число");
        }
        System.out.println("Число корректно");
    }

    public static Integer inputInt() {
        Scanner scanner = new Scanner(System.in);
        int result;
        System.out.println("Введите целое число: ");
        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                return result;
            } else {
                scanner.next();
                System.out.println("Введите целое число: ");
            }
        }
    }
}
class InvalidNumberException extends Exception{
    public InvalidNumberException(String message){
        super(message);
    }
}