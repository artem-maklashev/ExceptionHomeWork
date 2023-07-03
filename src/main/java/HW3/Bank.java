package HW3;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
Вы разрабатываете систему банковских транзакций. Необходимо написать программу,
которая позволяет пользователям осуществлять переводы средств со своего банковского счета на другие счета.
Однако, в системе существуют некоторые ограничения и возможные ошибки, которые нужно обрабатывать.

Требования:

При переводе средств, сумма должна быть положительной и не превышать доступный баланс на счете.
Если сумма перевода отрицательная или равна нулю, выбрасывается исключение InvalidAmountException с сообщением "Некорректная сумма перевода".
Если на балансе недостаточно средств для перевода, выбрасывается исключение InsufficientFundsException с сообщением "Недостаточно средств на счете".
При успешном переводе, сумма должна списываться с текущего счета и зачисляться на целевой счет.
 */
public class Bank {
    static double accountValue = 1000;
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);){
            double amount = getDoubleNumber(scanner, "Введите сумму перевода: ");
            transfer(amount);
            System.out.println("Сумма на счете " + accountValue + " бакинских рублей");
        }
    }
    public static void transfer(double amount)  {
        try {
            checkAccount(amount);
            checkAmount(amount);
            accountValue-=amount;
        } catch (InsufficientFundsException | InvalidAmountException ex) {
            System.out.println(ex.getMessage());
        }
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

    private static void checkAccount(double amount) throws InsufficientFundsException {
        if(accountValue<amount){
            throw new InsufficientFundsException("Недостаточно средств на счете.");
        }
    }

    private static void checkAmount(double amount) throws InvalidAmountException {
        if(amount<=0){
            throw new InvalidAmountException("Некорректная сумма перевода");
        }
    }

    static class InvalidAmountException extends Exception{
        public InvalidAmountException(String message){
            super(message);
        }
    }
    static class InsufficientFundsException extends Exception{
        public InsufficientFundsException(String message){
            super(message);
        }
    }
}
