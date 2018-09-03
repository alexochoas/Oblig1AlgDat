import java.util.NoSuchElementException;

public class Oblig1 {




    public static void main(String[] args){

        System.out.println("hei");

        int[] a = {1,500000,500000000,7,23400};
        System.out.println(maks(a));
        int[] b = {};
        maks(b);
        }


    public static void bytt(int[] a, int i, int j){

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    public static int maks(int[] a){

        if(a.length == 0){
            throw new NoSuchElementException("Array is empty.");
        }


        for(int i = 0;  i < a.length-1; i++){

            if (a[i] > a[i+1]){

                bytt(a, i,i+1);
            }

        }

        return a[a.length-1];



    }




}
