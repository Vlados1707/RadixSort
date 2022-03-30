package RadixSort;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i<51; i++){
            int[] array = readFileAndReturnIntArray(i);
            int arrayLgh = readFileAndReturnIntArray(i).length;
            RadixSort sort = new RadixSort();
            sort.radixsort(array, arrayLgh);
            long time = sort.returnTime();
            int iterations = sort.returnIteration();
            //System.out.println("№" + i + " Время работы " + time + " Кол-во итераций " + iterations);
            System.out.println(i + " " + time + " " + iterations);

            //System.out.println(Arrays.toString(array));
        }

    }


// Чтение из файла и превращение массива строк в массив интов
public static int[] readFileAndReturnIntArray(int i) throws IOException {
    String file = "D:\\Java Project\\s2\\RadixSort\\Files\\" + i + ".txt";
    String content = Files.lines(Paths.get(file)).reduce("", String::concat);
    String[] subContent = content.split(" ");
    int[] intArray = new int[subContent.length];
    for (int j = 0; j < subContent.length; j++) {
        try {
            Integer i1 = new Integer(subContent[j]);
            intArray[j] = i1;
        } catch (NumberFormatException e) {
            System.err.println("Ошибка! CreatingIntArray 19");
        }
    }
    return intArray;
}
}
