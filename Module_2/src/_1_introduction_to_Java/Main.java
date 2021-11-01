package _1_introduction_to_Java;

public class Main {
    public static void main( String[] args) {
        int ii = 10;
        float f = 20.5f;
        double d = 20.5;
        boolean b = false;
        char c = 'a';
        String s = "Đà Nẵng";
        System.out.println(ii);
        System.out.println(f);
        System.out.println(d);
        System.out.println(b);
        System.out.println(c);
        System.out.println(s);


        int[] a = {5, 6, 7, 8};

        for(int i=0; i < a.length; i++){

            if(a[i] % 2 == 0){

                continue;

            }
            System.out.print(i);
        }
    }

}
