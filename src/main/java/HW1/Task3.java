package HW1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task3 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            int total = 0;

            try {
                while(true) {
                    String line;
                    if ((line = br.readLine()) == null) {
                        System.out.println("Сумма чисел в файле: " + total);
                        break;
                    }

                    try {
                        total += Integer.parseInt(line);
                    } catch (NumberFormatException var5) {
                        throw new NumberFormatException("Некорректное значение числа в файле");
                    }
                }
            } catch (IOException var6) {
                System.out.println("Ошибка чтения из файла");
            }
        } catch (FileNotFoundException var7) {
            System.out.println("Файл отсутствует");
        }

    }
}
