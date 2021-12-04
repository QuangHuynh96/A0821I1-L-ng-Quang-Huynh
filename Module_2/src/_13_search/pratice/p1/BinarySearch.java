package _13_search.pratice.p1;

public class BinarySearch {
// không dùng đệ qui.
    static void binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        int check = 0;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key == list[mid]) {
                check = 1;
                System.out.println(key + " có index là: " + mid);
                break;
            }else if (key < list[mid])
                high = mid - 1;
            else if(key > list[mid] )
                low = mid + 1;
        }
        if( check == 0)
            System.out.println("không tìm thấy "+ key);;
    }

    public static void main(String[] args) {
        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        binarySearch(list, 2);
        binarySearch(list, 11);
        binarySearch(list, 79);
        binarySearch(list, 1);
        binarySearch(list, 5);
        binarySearch(list, 80);
    }
}
