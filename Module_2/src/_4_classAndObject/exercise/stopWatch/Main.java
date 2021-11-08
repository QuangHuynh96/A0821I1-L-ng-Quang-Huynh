package _4_classAndObject.exercise.stopWatch;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr= new int[100000];

        int length= arr.length;
        for (int i = 0; i < length; i++) {
            arr[i]= new Random().nextInt(99999);
        }
        StopWatch stopwatch=  new StopWatch();
        stopwatch.start();
        selectionSort(arr);
        stopwatch.stop();
        System.out.println(Arrays.toString(arr));
        System.out.println(stopwatch.getElapsedTime()+"s");


    }
    private static void selectionSort(int[] arr){
        int length= arr.length;
        for (int i = 0; i < length; i++) {
            int min_index=i;

            for (int j = i; j < length; j++) {
                if(arr[min_index]> arr[j])
                    min_index= j;
            }

            if(min_index!=i){
                int tmp= arr[min_index];
                arr[min_index]= arr[i];
                arr[i]= tmp;
            }
        }
    }
}
