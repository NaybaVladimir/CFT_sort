
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (!(args.length < 3)) {
            String sortMode = sortMode(args);
            String dataType = dataType(args, sc);
            String outFile = outFile(args, sc);
            List<String> fileName = fileName(args, sc);
            while (true) {
                if (!(fileName.isEmpty())) {
                    System.out.println("Итоговые данные для сортировки методом слияния:");
                    System.out.println("Метод сортировки: " + sortMode + " Тип данных: " + dataType + " Итоговый файл: " + outFile + " Файлы ввода: " + fileName.toString());
                    List<Object> values = Input.inputFileToArray(fileName);
                    ConvertToStringOrInteger.convert(values, dataType, sortMode, outFile);
                    System.out.println("Программа завершила работу, проверьте файл вывода.");
                    break;
                } else {
                    while (true) {
                        System.out.println("Введите наименование файла для сбора данных:");
                        String x = sc.nextLine();
                        File file = new File(x);
                        if (file.isFile()) {
                            fileName.add(x);
                            break;
                        } else
                            System.out.println("Файла " + x + " не существует.");

                    }
                }
            }
        } else
            System.out.println("Указано слишком мало входных данных.");


        sc.close();
    }

    //Проверяем правильность введенного метода сортировки
    public static String sortMode(String[] args) {
        String sortMode;
        if (args[0].equals("a") || args[0].equals("d"))
            sortMode = args[0];
        else {
            System.out.println("Метод сортировки по умолчанию - \"a\" - по возврастанию.");
            sortMode = "a";
        }
        return sortMode;

    }

    //Провереяем правильность введенного типа данных
    public static String dataType(String[] args, Scanner sc) {
        String dataType;

        if (args[0].equals("a") || args[0].equals("d")) {
            if (args[1].equals("s") || args[1].equals("i")) {
                dataType = args[1];
            } else {
                while (true) {
                    System.out.println("Не корректно указан тип данных. \"s\" - строки, \"i\" - целые числа.");
                    System.out.println("Введите тип данных:");
                    dataType = sc.nextLine();
                    if (dataType.equals("s") || dataType.equals("i"))
                        break;
                }
            }
        } else {
            if (args[0].equals("s") || args[0].equals("i")) {
                dataType = args[0];
            } else {
                while (true) {
                    System.out.println("Не корректно указан тип данных. \"s\" - строки, \"i\" - целые числа.");
                    System.out.println("Введите тип данных:");
                    dataType = sc.nextLine();
                    if (dataType.equals("s") || dataType.equals("i"))
                        break;
                }
            }


        }

        return dataType;
    }

    //Проверяем правильность введенного итогового файла
    public static String outFile(String[] args, Scanner sc) {
        String outFile = null;
        File file = null;


        if (args[1].length() == 1) {
            file = new File(args[2]);
            outFile = args[2];
            while (true) {
                if (file.isFile())
                    break;
                else {
                    System.out.println("Файла" + outFile + " не существует. Введите корректное наименование файла для вывода результата:");
                    outFile = sc.nextLine();
                    file = new File(outFile);
                }
            }
        } else {
            outFile = args[1];
            file = new File(args[1]);
            while (true) {
                if (file.isFile())
                    break;
                else {
                    System.out.println("Файла" + outFile + " не существует. Введите корректное наименование файла для вывода результата:");
                    outFile = sc.nextLine();
                    file = new File(outFile);
                }
            }
        }

        return outFile;
    }

    //Проверяем правильность введененных входных файлов
    public static List<String> fileName(String[] args, Scanner sc) {
        List<String> inFile = new ArrayList<>();
        String fileName;
        File file = null;
        int i;
        if (args[1].length() == 1)
            i = 3;
        else
            i = 2;
        while (i < args.length) {
            fileName = args[i];
            file = new File(fileName);
            while (true) {
                if (!(file.isFile())) {
                    System.out.println("Файл " + fileName + " не существует. Введите корректное наименование файла для приема входных данных:");
                    fileName = sc.nextLine();
                    file = new File(fileName);
                } else
                    break;
            }
            inFile.add(fileName);
            i++;
        }


        return inFile;
    }

    //a i C:/Новаяпапка/out.txt C:/Новаяпапка/1.txt
}
