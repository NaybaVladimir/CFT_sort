import java.util.ArrayList;
import java.util.List;

public class ConvertToStringOrInteger {
    //Определяем строки или числа будем сортировать и отправляем на конвертацию
    public static void convert(List<Object> values, String dataType, String sortMode, String outFile) {
        if (dataType.equals("i"))
            convertToInteger(values, sortMode, outFile);
        else
            convertToString(values, sortMode, outFile);
    }
    //Конвертируем и фильтруем объекты в числа
    public static void convertToInteger(List<Object> values, String sortMode, String outFile) {
        List<Integer> list = new ArrayList<>();
        for (Object el : values) {
            try {
                list.add(Integer.parseInt((String) el));
            } catch (NumberFormatException e) {
                System.out.println("Одним из элементов файла оказалась строка: \"" + el + "\" - не учитывается при сортировке.");
            }
        }
        OutputSort.sortInteger(list, sortMode, outFile);
    }
//Конвертируем и фильтруем объекты в строки
    public static void convertToString(List<Object> values, String sortMode, String outFile) {
        List<String> list = new ArrayList<>();
        for (Object el : values) {
            if (ConvertToStringOrInteger.test(el))
            {list.add((String) el);}
            else
                System.out.println("Одним из элементов файла оказалось число: \"" + el + "\" - не учитывается при сортировке.");
        }

        OutputSort.sortString(list, sortMode, outFile);
    }
//Проверка на наличие посторонних символов в строке
    public static boolean test(Object x) {
        String s = (String) x;
        boolean tf = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                tf = true;
            else{
                tf = false;
            break;}
        }
        return tf;
    }
}

