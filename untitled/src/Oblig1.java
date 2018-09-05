import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {




    public static void main(String[] args){

        System.out.println("hei");

       // int[] a = {1,500000,500000000,7,23400};
       // int[] best = {1,2,3,4,5,6,7,8,9};
       // int[] worst = {9,8,7,6,5,4,3,2,1};

        /*int[] h = new int[1000];


        for (int i = 0; i<h.length; i++){
            h[i] = i;
        }

        //System.out.println(maks(a));
        //System.out.println(ombyttinger(best));
        //System.out.println(ombyttinger(worst));

        double sum = 0;
        double ombyttinger;
        int teller = 0;

        for(int i = 0; i<1000; i++){
            randPerm(h);
            printArray(h);
            ombyttinger = ombyttinger(h);
            System.out.println("antall bytter " +
                    ombyttinger);
            System.out.println(ombyttinger);
            sum = sum + ombyttinger;
            System.out.println(sum);

        }

        double gjennomsnitt = sum/1000;

        System.out.println("gjennomsnittet er " +gjennomsnitt);

*/

        int[] a = {3,3,10,5,7,7,8,8,9};

        int[] b = {5,99,7,4,3,5,7,8,6,888};

        int[] h = {1,2,3,4,5,1};

        System.out.println(maks(b, 0,1));

        System.out.println(antallUlikeUsortert(b));
        }


    public static void bytt(int[] a, int i, int j){

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    //maks metoden, men med fra og til grenser.
    public static int maks(int[] a){

        if(a.length == 0){
            throw new NoSuchElementException("Array is empty.");
        }


        for(int i = 0;  i < a.length-1; i++){

            if (a[i] > a[i+1]){
                bytt(a, i,i+1);
            }

        }

        for (int element:a) {
            System.out.print(element+ " ");

        }
        System.out.println();

        return a[a.length-1];


    }


    public static int maks(int[] a, int fra, int til){

        if(a.length == 0){
            throw new NoSuchElementException("Array is empty.");
        }

        if(fra > til){
            throw new IllegalArgumentException("Ikke lovlige grenser.");
        }




        for(int i = fra;  i < til-1; i++){

            if (a[i] > a[i+1]){
                bytt(a, i,i+1);
            }

        }

        return a[til-1];


    }

    //Metode som
    public static void min(int[] a, int fra, int til){




    }



    public static int ombyttinger(int[] a){

        if(a.length == 0){
            throw new NoSuchElementException("Array is empty.");
        }

        // Teller
        int n = 0;


        for(int i = 0;  i < a.length-1; i++){

            if (a[i] > a[i+1]){
                n++;
                //bytt(a, i,i+1);
            }

        }

        return n;

    }


    public static void randPerm(int[] a) // stokker om a
    {
        Random r = new Random();  // hentes fra java.util

        for (int k = a.length-1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }



    public static int antallUlikeSortert(int[] a){

        if (!sorted(a)){
            throw new IllegalStateException("Tabellen er ikke sortert stigende");
        }

        if(a.length == 0){
            return 0;
        }

        // Teller antall ulike
        int n = 1;

        for(int i = 0; i < a.length-1; i++){

            if(a[i] != a[i+1]){
                n++;
            }

        }

        return n;


    }

    public static boolean sorted(int[] a){

        boolean sorted = true;

        for(int i = 0; i < a.length-1; i++){

            if(a[i] > a[i+1]){
                sorted = false;
            }


        }

        return sorted;





    }











    public static int[] randPerm(int n)
    {
        int[] a = new int[n]; // fyller tabellen med 1, 2, . . , n
        for (int i = 0; i < n; i++) a[i] = i+1;

        Random r = new Random();  // hentes fra java.util

        for (int k = n-1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }

        return a; // tabellen med permutasjonen returneres

    } // randPerm


    public static void printArray(int[] a){

        for(int i: a){

            System.out.print(i + " ");


        }
    }


    public static int antallUlikeUsortert(int[] a){

        //Antall ulike
        int n = a.length;

        //Antall treff indre loop
        int b = 0;
        for(int i = 1; i < a.length; i++){


            for(int k = i-1; k >= 0 && b < 1; k--){
                if(a[k] == a[i]){
                    n--;
                    b++;

                }
            }

            b = 0;


        }




        return n;
    }


    public static void delSortering(int[] a){

        //hjelpevariabel for partall
        int p = a.length-1;

        //hjelpevariavel for oddetall
        int o = 0;

        for(int i = 0; i < a.length; i++){


        }



    }



}
