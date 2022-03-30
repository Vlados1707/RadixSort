package RadixSort;

import java.io.*;
import java.util.Random;

public class FileCreator {

    static Random rnd = new Random();

    public static void main(String[] args) throws IOException {
        createFile();
    }
    public static void createFile() throws IOException {

        int countFields = 50;
        for (int i = 0; i <= countFields ; i++) {
            File file = new File("D:\\Java Project\\s2\\RadixSort\\FF\\" + i + ".txt");
            if (file.createNewFile()) {

                if(i == 0) {
                    write(file, 200);

                } else {
                    int rndCount = (i+1)*200;
                    write(file, rndCount);
                }

            } else {throw new IOException();
            }
        }
    }

    public static void write(File field, int rndCount) throws IOException {
        FileWriter writer = new FileWriter(field);
        for (int i = 0; i < rndCount ; i++) {
            writer.write( rnd.nextInt(-100000, 100001) + " ");
        }
        writer.close();
    }
}
