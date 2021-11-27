package _13_Search.exercise.o_e2;

public class BinarySearchInArray {
    public static void main(String[] args) {
        int[] array = {1,3,5,4,9,52,7,5,6};
//        sắp xếp mảng trước.
        int length = array.length;
        for(int i = 0; i < length; i++) {
            for( int j = i + 1; j < length; j++) {
                if( array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
//        hiển thị mảng đã được sắp xếp.
        for( int i: array) {
            System.out.print( i);
        }
        System.out.println();

//        test hàm.
        BinarySearch(array, 6);
        BinarySearch(array, 10);
    }




    public static int BinarySearcher(int[] array, int left, int right, int number) {
        int midIndex = (left + right)/2;
        if(left > right) {
          return -1;
        } else if( number > array[midIndex]) {
            return BinarySearcher(array, midIndex +1, right, number);
        }else if(number < array[midIndex]){
            return BinarySearcher(array, left, midIndex - 1, number);
        }else// number == array[midIndex]
        return midIndex;
    }
    public static void BinarySearch(int[] array, int number) {
        int index = BinarySearcher(array,0, array.length -1,number);
        if( index == -1) {
            System.out.println(number +" không thuộc mảng");
        }else {
            System.out.println(number+ " có index là "+ index);
        }
    }

}
