package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileWork {
    private static final String SEARCHING_LETTER_LOW = "w";
    private static final String SEARCHING_LETTER_UP = "W";

    public String[] readFromFile(String fileName) {
        //write your code here
        String tmp;
        String[] arrStr = new String[0];
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder(4096);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            tmp = bufferedReader.readLine();
            while (tmp != null) {
                arrStr = tmp.split("[!?;:^,.'\"\\- ]");
                for (String str : arrStr) {
                    if (str.startsWith(SEARCHING_LETTER_LOW)
                            || str.startsWith(SEARCHING_LETTER_UP)) {
                        stringBuilder.append(str.toLowerCase()).append(" ");
                    }
                }
                tmp = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (arrStr.length == 0 || stringBuilder.length() == 0) {
            return new String[0];
        }
        arrStr = stringBuilder.toString().split(" ");

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 1; i < arrStr.length; i++) {
                if (arrStr[i - 1].compareTo(arrStr[i]) > 0) {
                    tmp = arrStr[i - 1];
                    arrStr[i - 1] = arrStr[i];
                    arrStr[i] = tmp;
                    flag = true;
                }
            }
        }
        return arrStr;
    }
}
