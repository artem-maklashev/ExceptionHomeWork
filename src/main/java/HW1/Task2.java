package HW1;

import java.util.Scanner;

public class Task2 {
    public Task2() {
    }

    public static void main(String[] args) {
        System.out.println("Возраст: " + getAge());
    }

    public static int getAge() {
        Scanner scanner = new Scanner(System.in);
        int age = 0;

        try {
            System.out.print("Введите возраст: ");
            String str = scanner.nextLine();
            age = Integer.parseInt(str);
        } catch (NumberFormatException var3) {
            System.out.println("Некорректный ввод");
        }

        return age;
    }
}
