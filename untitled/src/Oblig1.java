import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {




    public static void main(String[] args){

        System.out.println("hei");


        System.out.println(-4%2);

       // int[] a = {1,500000,500000000,7,23400};
       // int[] best = {1,2,3,4,5,6,7,8,9};
       // int[] worst = {9,8,7,6,5,4,3,2,1};





        //System.out.println(maks(a));
        //System.out.println(ombyttinger(best));
        //System.out.println(ombyttinger(worst));

        double sum = 0;
        int teller = 0;



        for(int i = 0; i < 100; i++){

            sum = sum + ombyttinger(Oblig1Test.randPerm(100000));
            //System.out.println(sum);

        }

        System.out.println(sum/100);





        int[] a = {3,3,10,5,7,7,8,8,9};

        int[] b = {5,99,7,4,3,5,7,8,6,888};



        int[] pp = {1, 2, 3, 4, 5, 6};

        delsortering(pp);


        int[] tab = randPerm(10);

        //System.out.println(maks(b, 0,1));

        //System.out.println(antallUlikeUsortert(b));

        String s = "ABCDEETTTTT";
        String t = "HHHHHH";

        //System.out.println(flett(s,t));

        String[] strings = {"AM ","L","GEDS","ORATKRR","","R TRTE","IO","TGAUU"};
        //System.out.println(flett(strings));



        String string = "ABBAAH";





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


    //Når det storste tallet i arrayet ligger forst vil det vaere flest ombyttinger.
    //Det er faerrest når arrayet er sortert etter stigende rekkefølge.
    //I forgold til maks metoder vi har sett på tidligere er denne svært inneffektiv for store arrayer.


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




    // I gjennomsnitt blir antall ombyttinger lik n-hn. Der n er antall elementer i arrayet, og hn er
    // det harmoniske tallet log(n) + 0,557.
    //
    public static int ombyttinger(int[] a){

        if(a.length == 0){
            throw new NoSuchElementException("Array is empty.");
        }

        // Teller
        int n = 0;


        for(int i = 0;  i < a.length-1; i++){

            if (a[i] > a[i+1]){
                bytt(a, i,i+1);
                n++;
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
        int treff = 0;
        for(int i = 1; i < a.length; i++){


            for(int k = i-1; k >= 0 && treff < 1; k--){
                if(a[k] == a[i]){
                    n--;
                    treff++;

                }
            }

            treff = 0;


        }


        return n;
    }


    public static void delsortering(int[] a){


        int oddetallIndeks = 0;

        int partallIndeks = 0;

        for(int i = 0;  i < a.length; i++){

            if (a[i] % 2 != 0){
                bytt(a, i, oddetallIndeks);
                oddetallIndeks++;
            } else{

                partallIndeks++;
            }
        }

        if (partallIndeks == 0 || oddetallIndeks == 0){

            kvikkSort(a, 0, a.length-1);

        } else {

            kvikkSort(a,oddetallIndeks, a.length-1);
            kvikkSort(a, 0, oddetallIndeks-1);
        }









    }


    public static void kvikkSort(int[] a, int v, int h){


        if(h-v > 0 ) {
            int pivot = h;

            int wall = v;



                /*while(v<=h && wall <= h) {

                    while (a[v] >= a[pivot]) {
                        v++;
                    }

                    bytt(a, v, wall);
                    wall++;

                }*/


                for(int i = v; i < h;){

                    if(a[i] < a[pivot]){
                        bytt(a, i, wall);
                        wall++;
                        i++;
                    } else {
                        i++;

                    }




            }


            bytt(a,pivot,wall);


            //setter nye venstre og høyre grenser




            kvikkSort(a, v, wall - 1);


            h = pivot;
            kvikkSort(a, wall +1, h);





        }




    }


    public static void rotasjon(char[] a){


        char tmp = a[a.length-1];

        for(int i = a.length - 2; i >= 0; i--){
            a[i+1] = a[i];
        }

        a[0] = tmp;

    }



    public static void rotasjon(char[] a, int k) {





// Dersom k er positiv
        if(k > 0) {
            char tmp = a[a.length - 1];

            for (int i = a.length - 2; i >= 0; i--) {
                a[i + 1] = a[i];
            }

            a[0] = tmp;

            k--;
            if (k > 0) {
                rotasjon(a, k);
            }
        } else {

            // dersom k er negativ

            char tmp = a[0];

            for (int i = 1; i < a.length; i++){

                a[i-1] = a[i];
            }

            a[a.length-1] = tmp;

            k++;

            if(k < 0){
                rotasjon(a, k);

            }

        }

    }


    public static String flett(String s, String t){

        int s_index = 0;
        int t_index = 0;


        //index
        int i;

        char[] flettet = new char[s.length() + t.length()];

        for(i = 0; (i < flettet.length) || (s_index < s.length()-1 || t_index < t.length()-1); i++){

            if(s_index == s.length() || t_index == t.length()){
                break;
            }

            if (i%2 == 0){

                flettet[i] = s.charAt(s_index);
                s_index = s_index + 1;
            } else {
                flettet[i] = t.charAt(t_index);
                t_index = t_index + 1;
            }

        }

        System.out.println(" si: " + s_index + " ti: " + t_index);

        System.out.println(i);


        if(s_index == s.length() && t_index == t.length()){

            System.out.println("ferdig");

        }


        //Legger til elementene til overs

        System.out.println(String.valueOf(flettet));





        if(s_index == s.length() && t_index != t.length()){

            System.out.println("legger til fra t");

            for(i = i; i < flettet.length; i++){
                flettet[i] = t.charAt(t_index);
                t_index++;
            }

        } else if(t_index == t.length() && s_index != s.length()){
            System.out.println("legger til fra s");

            for(i = i; i < flettet.length; i++){
                flettet[i] = s.charAt(s_index);
                s_index++;
            }
        }





        return String.valueOf(flettet);
    }

    public static String flett(String... s){

        String flettet = "";

        StringBuilder stringBuilder = new StringBuilder(flettet);

        for(int i = 0; i < s.length; i++){

            for(int k = 0; k < s.length; k++){

                if(i < s[k].length())
                stringBuilder.append(s[k].charAt(i));

            }


        }


        return stringBuilder.toString();


    }


    public static int[] indekssortering(int[] a){

        int[] hjelpetabell = new int[a.length];

        int[] indekser = new int[a.length];


        //kopierer a til hjelpetabell
        for (int i = 0; i < hjelpetabell.length; i++){

            hjelpetabell[i] = a[i];
        }


        for(int i = 0; i < hjelpetabell.length; i++){

            indekser[i] = minIndex(hjelpetabell);
            // Setter elementet til minste verdien til int.
            hjelpetabell[indekser[i]] = 2147483647;

        }






        return indekser;

    }



    public static int minIndex(int[] a){

        //maxverdi
        int m = 0;


        for (int i = 0; i < a.length; i++){

            if(a[i] < a[m]){
                m = i;
            }


        }

        return m;

    }


    public static int[] tredjeMin(int[] a){

        if (a.length < 3){
            throw new NoSuchElementException("Arrayet må ha minst tre verdier");

        }

        int[] hentIndex = {a[0], a[1], a[2]};

        hentIndex = indekssortering(hentIndex);

        int tmp = 0;

        int min = hentIndex[0];
        int nmin = hentIndex[1];
        int tnmin = hentIndex[2];

        int minVerdi = a[min];
        int nestMinVerdi = a[nmin];
        int tredMinstVerdi = a[tnmin];

        System.out.println(minVerdi);
        System.out.println(nestMinVerdi);
        System.out.println(tredMinstVerdi);


        for(int i = 3; i < a.length; i++){

            if(a[i] < tredMinstVerdi){

                if(a[i] < nestMinVerdi){

                    if (a[i] < minVerdi){


                        //ny tred minst

                        tnmin = nmin;
                        tredMinstVerdi = nestMinVerdi;


                        //ny nest min
                        nmin = min;
                        nestMinVerdi = minVerdi;



                        // ny min
                        min = i;
                        minVerdi = a[i];

                    } else{

                        //ny tred mest min
                        tnmin = nmin;
                        tredMinstVerdi = nestMinVerdi;

                        // ny nest min
                        nmin = i;
                        nestMinVerdi = a[i];
                    }

                } else {

                    // ny tred min
                    tnmin = i;
                    tredMinstVerdi = a[i];
                }
            }







        }
        System.out.println(minVerdi);
        System.out.println(nestMinVerdi);
        System.out.println(tredMinstVerdi);

        return new int[] {min, nmin, tnmin};















    }









public static boolean inneholdt(String a, String b){


        char[] alfabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Æ','Ø','Å'};


        int[] c = new int[alfabet.length];

        for(int i = 0; i < a.length(); i++) {

            for(int k = 0; k < alfabet.length; k++){

                if(a.charAt(i) == alfabet[k]){
                    c[k]++;


                }

            }

        }


        for(int i = 0; i < b.length(); i++){

            for(int k = 0; k < alfabet.length; k++){

                if(b.charAt(i) == alfabet[k]){

                    c[k]--;
                }


            }

        }

        //

        for(int i = 0; i < c.length; i++){

            if(c[i] > 0){
                return false;
            }

        }

        return true;

}









}