package _16_textFile.exercise.e2_readFile;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DisplayFile nation = new DisplayFile();
        nation.Display(nation.readFile("_16_textFile/exercise/e2_readFile/nation.cvs"));
    }
}
