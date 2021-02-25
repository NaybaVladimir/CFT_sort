
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class OutputSort {
    //Сортируем строки
    public static void sortString(List<String> list, String sortMode, String outFile) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++)
            array[i] = list.get(i);
        String tmp;
        int j;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            j = i - 1;
            while (j >= 0 && (sortMode.equals("a") ? array[j].compareTo(tmp) > 0 : array[j].compareTo(tmp) < 0)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
        OutputSort.output(array, outFile);
    }

//Сортируем числа
    public static void sortInteger(List<Integer> list, String sortMode, String outFile) {
        Integer[] array = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++)
            array[i] = list.get(i);

        int tmp;
        int j;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            j = i - 1;
            while (j >= 0 && (sortMode.equals("a") ? array[j] > tmp : array[j] < tmp)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }
        OutputSort.output(array, outFile);
    }
//Загружаем данные в файл
    public static void output(Object[] array, String outFile) {
        PrintWriter write = null;
        try {
            write = new PrintWriter(outFile);
            for (Object el:array)
                write.println(el);
            write.close();
        } catch (FileNotFoundException e) {
            /*Как обработать исключение?*/
            System.out.println("Файл" + outFile + "отсутствует");
        }
if (!(write==null))
    write.close();
    }
}
