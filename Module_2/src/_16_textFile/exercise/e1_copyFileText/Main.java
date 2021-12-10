package _16_textFile.exercise.e1_copyFileText;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CopyFileChar copy = new CopyFileChar();
        System.out.println("Enter filePath in: ");
        String pathIn = scanner.nextLine();
        List<String> list = copy.readFile(pathIn);

        System.out.println("Enter filepath out: ");
        String pathOut = scanner.nextLine();

        System.out.println(copy.writeFile("_16_textFile/exercise/e1_copyFileText/"+pathOut, list));
    }
}
