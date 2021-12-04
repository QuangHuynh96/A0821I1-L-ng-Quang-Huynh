package _16_textFile.practice.p2;

import java.util.List;

import static _16_textFile.practice.p2.FindMaxValue.findMax;

 class Main {
     public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("_16_textFile/practice/p2/text.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("result.txt", maxValue);
    }
}