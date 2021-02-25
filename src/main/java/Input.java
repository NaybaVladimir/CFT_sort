import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    //Выгружаем из фала данные
    public static List<Object> inputFileToArray(List<String> inputFile) {
        List<Object> values = new ArrayList<>();
        File file;
        Scanner sc = null;

        for (String el : inputFile) {
            file = new File(el);
            try {
                sc = new Scanner(file);
                while (sc.hasNext())
                    values.add(sc.next());
            } catch (FileNotFoundException e) {
                /*Как обработать исключение?*/
                System.out.println("Файл" + el + "отсутствует");

            }
        }
        if (sc != null)
            sc.close();
        return values;
    }
}
