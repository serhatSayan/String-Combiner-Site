package com.beforefirtina.beforeFirtina;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CumleBirlestirme {

    public static void main(String[] args) {

        List<String> testGirdiler = new ArrayList<String>();
        testGirdiler.add("Ali eve gel");
        testGirdiler.add("eve gel sonra");
        testGirdiler.add("eve gel sonra çarşı");
        testGirdiler.add("çarşıya git");

        System.out.println(cumleBirlesir(testGirdiler));

    }

    // "==" operatorü ile aynı şeyi yapıyor gibi?
    private static boolean CompWord(String kelime1, String kelime2) {
        if (kelime1.length() != kelime2.length()) {
            return false;
        }
        for (int i = 0; i < kelime1.length(); i++) {
            if (kelime1.charAt(i) != kelime2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static Boolean CompWords(String kelime1, String kelime2) {

        //tüm harfleri küçük harfe çevirme
        kelime1 = kelime1.toLowerCase();
        kelime2 = kelime2.toLowerCase();

        //kelimelerden birisi diğerini içeriyor mu kontrolü
        if (kelime1.contains(kelime2)) {
            //eğer içeriyorsa kelime2 kelime1'in kökü mü kontrolü (Türkçe sondan elemeli olduğu için)
            if (0 == kelime1.indexOf(kelime2)) return true;

        } else if (kelime2.contains(kelime1)) {
            //eğer içeriyorsa kelime1 kelime2'in kökü mü kontrolü (Türkçe sondan elemeli olduğu için)
            if (0 == kelime2.indexOf(kelime1)) return true;
        }

        return false;
    }

    public static BirlesikMetinDoc cumleBirlesir(List<String> girdiler){

        long startTime = System.nanoTime();

        String birlesmisMetin = "";

        for (int sira =0; sira < girdiler.size(); sira++) {
            String metin = girdiler.get(sira);

            if (metin.equals("exit")) {
                break;
            }

            //metinleri kelimelere bölerek String dizilerine atıyoruz
            String[] kelimeler1 = birlesmisMetin.split(" ");
            String[] kelimeler2 = metin.split(" ");



            // kelimeler1 ve kelimeler2 deki kelimeleri birleştir

            //önce birleşmiş metinleri ayırıp kelimeler1'e atıyoruz hemen ardından kelimeler1'in kelimelerini
            //birlesmisMetine ekliyor ???
            for (int i = 0; i < kelimeler1.length; i++) {
                birlesmisMetin += kelimeler1[i];
                //cümle sonu hariç kelimelerin ardından boşluk koyma
                if (i < kelimeler1.length - 1) {
                    birlesmisMetin=birlesmisMetin+" ";
                }
            }

            //kelimeler2'de bulunan kelimelerin kelimeler1'de de bulunup bulunmadığını kontrol ediyor
            //bulunmayan kelimeleri birlesikMetin'e ekliyor
            for (int i = 0; i < kelimeler2.length; i++) {
                boolean kelimeVar = false;
                for (int j = 0; j < kelimeler1.length; j++) {
                    if (CompWord(kelimeler2[i], kelimeler1[j])) {
                        kelimeVar = true;
                        break;
                    }
                }
                if (kelimeVar==false) {
                    birlesmisMetin=birlesmisMetin+" "+ kelimeler2[i];
                }
            }
        }

        String[] lastword = birlesmisMetin.split(" ");
        String lastText = "";



        for (int i = 0; i < lastword.length; i++) {
            boolean addWord = true;
            for (int j = i + 1; j < lastword.length; j++) {

                //eğer diğer kelimeyi içinde barındıran kelime ikinci kelimenin içinde bulunuyorsa ilk kelimeyi eklemiyor
                //ama ikinci kelime ilk kelimede bulunsa bile ikinci kelimeyi ekliyor
                if (lastword[j].indexOf(lastword[i]) == 0) {
                    addWord = false;
                    break;
                }
            }
            if (addWord==true) {
                lastText=lastText+lastword[i] + " ";
            }
        }

        BirlesikMetinDoc birlesikMetinObjesi = new BirlesikMetinDoc();
        birlesikMetinObjesi.setBirlesikMetin(lastText);
        birlesikMetinObjesi.setSure((System.nanoTime()-startTime)/1000000000.0);

        return birlesikMetinObjesi;

    }

}
