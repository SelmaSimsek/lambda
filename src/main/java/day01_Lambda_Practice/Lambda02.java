package day01_Lambda_Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda02 {
    public static void main(String[] args) {

        List<String> meyve = new ArrayList<>(Arrays.asList("elma", "Portakal", "uzum","cilek","greyfurt","nar",
                "mandalina", "armut","elma","keciboynuzu", "elma"));


        ilkHarfEveyaC(meyve);
        System.out.println("***************");
        basinaVeSonunaYildiz(meyve);
        System.out.println("***************");
        icindeEharfiOlanlar(meyve);
        System.out.println("***************");
        lHarfiniSil(meyve);
        System.out.println("***************");
        karakterSayisinaGöreKucuktenBuyugeLambdaEx(meyve);
        System.out.println("***************");
        karakterSayisinaGöreKucuktenBuyugeMethodReferans(meyve);
        System.out.println("***************");



    }
    // SORU1 : List elemanlarının ilk harfi 'e' veya 'c' olanlari,
    // Method References ile aralarında bosluk bırakarak yazdıralım
    public static void ilkHarfEveyaC(List<String> meyve){
        meyve.stream().filter(t-> t.startsWith("e") || t.startsWith("c")).forEach(Utils::yazdir);

    }
    // SORU2 : List elemanlarının hepsinin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void basinaVeSonunaYildiz(List<String> meyve){
        meyve.stream().map(t-> "*"+t+"*").forEach(Utils::yazdir);


    }

    // SORU3 : List elemanlarının icinde 'e' harfi olanları yazdırın
    public static void icindeEharfiOlanlar(List<String> meyve) {
        meyve.stream().filter(t -> t.contains("e")).forEach(Utils::yazdir);

    }
    // SORU4 : List elemanlarındaki 'l' harflerini silip yazdırınız
    public static void lHarfiniSil(List<String> meyve){
        meyve.stream().map(t-> t.replace("l","")).forEach(Utils::yazdir);
    }
    // SORU5 : List elemanlarini, Lambda Expression kullanarak
// karakter sayisina göre kucukten buyuge dogru sıralayarak yazdırınız

    public static void karakterSayisinaGöreKucuktenBuyugeLambdaEx(List<String>meyve){
        meyve.stream().sorted(Comparator.comparing(t-> t.length())).forEach(Utils::yazdir);
    }
    // SORU6 : List elemanlarini, Method References kullanarak
// karakter sayisina göre buyukten kucuge dogru sıralayarak yazdırınız
    public static void karakterSayisinaGöreKucuktenBuyugeMethodReferans(List<String>meyve){
        meyve.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::yazdir);
    }

}
