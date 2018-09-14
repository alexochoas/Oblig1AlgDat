
//Alexander Svendberg s325887

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {



    // metode for å bytte to elementer i et array.
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





        if(a.length > 1) {
            char tmp = a[a.length - 1];

            for (int i = a.length - 2; i >= 0; i--) {
                a[i + 1] = a[i];
            }

            a[0] = tmp;
        }

    }





    public static void rotasjon(char[] a, int k){



        if(a.length < 2) return;


        //Sjekker om tabellen skal roteres mot klokkan.
        if((k %= a.length) < 0) {
           k += a.length;
       }

       //Finner antall sykler som trengs.
       int s = gcd(a.length, k);


        for(int d = 0; d < s; d++){

            //holder på verdien til første element
            char tmp = a[d];

            for(int i = d - k, j = d; i != d; i -=k){

                if(i < 0) {
                    i += a.length;
                }
                a[j] = a[i];
                j = i;
            }



            a[d + k] = tmp;
        }







    }



    //Finner største felles divisor
    public static int gcd(int a, int b){

        return b == 0 ? a : gcd(b, a % b);

    }



    public static void bytt(char[] a, int i, int j){

            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;

        }






    /*public static void rotasjon(char[] a, int k) {





// Dersom k er positiv
        if(a.length > 1) {
            if (k > 0) {
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

                for (int i = 1; i < a.length; i++) {

                    a[i - 1] = a[i];
                }

                a[a.length - 1] = tmp;

                k++;

                if (k < 0) {
                    rotasjon(a, k);

                }

            }
        }
        }
    }*/


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




        if(s_index == s.length() && t_index == t.length()){



        }


        //Legger til elementene til overs






        if(s_index == s.length() && t_index != t.length()){


            for(i = i; i < flettet.length; i++){
                flettet[i] = t.charAt(t_index);
                t_index++;
            }

        } else if(t_index == t.length() && s_index != s.length()){

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