package day01_Lambda_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {

    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(-5,-8,-12,0,1,12,5,5,6,9,15,8));

        ciftvePozitifLambdaExpression(sayi);
        System.out.println("**************");
        ciftvePozitifMethodReferences(sayi);
        System.out.println("**************");
        kare(sayi);
        System.out.println("**************");
        kareTekrarsiz(sayi);
        System.out.println("**************");
        buyuktenKucuge (sayi);
        System.out.println("**************");
        pozitifKupBirlerBasamagi5 (sayi);
        System.out.println("**************");
        toplamiMethodReferences(sayi);
        System.out.println("**************");
        toplamiLambdaExpression(sayi);
        System.out.println("**************");
        System.out.println(pozitifCarpimLambdaExpression(sayi));
        System.out.println("**************");
        System.out.println(kareCarpimKucuktenBuyugeListReturn(sayi));
        System.out.println("**************");
        System.out.println("**************");
        System.out.println("**************");
        System.out.println("**************");





    }

    //SORU1: List elemanlarının çift ve pozitif olanlarını,
    // Lambda Expression kullanarak aralarında bosluk olacak sekilde yazdırın

    public static void ciftvePozitifLambdaExpression(List<Integer> sayi){

        sayi.stream().filter(t-> t%2==0 && t>0).forEach(t-> System.out.print(t+" "));
}
        //SORU2: List elemanlarının çift ve pozitif olanlarını,
        // Method Referances kullanarak aralarında bosluk olacak sekilde yazdırın

    public static void ciftvePozitifMethodReferences(List<Integer> sayi) {

        sayi.stream().filter(Utils::ciftPozitifBul).forEach(Utils::yazdir);

    }

        //List elemanlarinin karelerini, aralarinda bosluk olacak sekilde yazdirin

    public static void kare(List<Integer> sayi){
        sayi.stream().map(t-> t*t).forEach(Utils::yazdir);
    }

    //SORU4 : List elemanlarının karelerini, tekrarsiz yazdırın
    public static void kareTekrarsiz(List<Integer> sayi){
        sayi.stream().map(t-> t*t).distinct().forEach(Utils::yazdir);
    }
    //soru 5_ List elemanlarini büyükten Kücüge siralayarak yazdirin
    public static void buyuktenKucuge (List<Integer> sayi){
        sayi.stream().sorted(Comparator.reverseOrder()).forEach(Utils::yazdir);
    }

    // SORU6 : List elemanlarının pozitif olanlarının, kuplerini bulup, birler basamagı 5 olanları yazdırınız

    public static void pozitifKupBirlerBasamagi5 (List<Integer> sayi){
        sayi.stream().filter(t-> t>0).map(t-> t*t*t).filter(t-> t%10==5).forEach(Utils::yazdir);
    }

    // SORU7: List elemanlarının Method References ile toplamını bulun ve yazdırın
    public static void toplamiMethodReferences(List<Integer> sayi){
        sayi.stream().reduce(Integer::sum);
    }
    // SORU8: List elemanlarının Lambda Expression ile toplamını bulun ve yazdırın
    public static void toplamiLambdaExpression(List<Integer> sayi){
        int sonuc = sayi.stream().reduce(0,(t,u)-> t+u);
        System.out.println(sonuc);
    }

    //SORU9 : Listin pozitif elemanlarının, carpımını
    // Lambda Expression ile return ederek yazdırın

    public static int pozitifCarpimLambdaExpression (List<Integer> sayi){
      int sonuc =   sayi.stream().filter(t-> t>0).reduce(1,(t,u)-> t*u);
      return sonuc;

    }

    //SORU10 : Listin cift elemanlarının, karelerini, kucukten buyuge sıralayıp list halinde return ederek yazdırınız
    public static List<Integer> kareCarpimKucuktenBuyugeListReturn (List<Integer> sayi){
       List<Integer> sonuc =  sayi.stream().filter(t-> t%2==0).map(t-> t*t).sorted().collect(Collectors.toList());
        return sonuc;

    }




}
