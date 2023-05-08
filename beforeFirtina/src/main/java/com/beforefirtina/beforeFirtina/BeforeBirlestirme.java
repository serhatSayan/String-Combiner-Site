package com.beforefirtina.beforeFirtina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BeforeBirlestirme {

        public static void main(String[] args) {

            //CompWord Test
            String compTest1 = "Çarşı";
            String compTest2 = "çarşıya";
            System.out.println(CompWords(compTest1, compTest2));


        }

        public static Boolean CompWords(String kelime1, String kelime2) {

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

        public static String BirlestirMetin(List<String> kelimeListesi) {

            List<String[]> ayrikListe = new ArrayList<>();

            //cümleleri kelimelere ayırma
            for (int i = 0; i < kelimeListesi.size(); i++) {
                ayrikListe.add(kelimeListesi.get(i).split(""));
            }


            return "";
        }

        /*public static String LongestCommonPrefix(String[] kelimeler){
            int size = kelimeler.length;

            if (size == 0) return "";
            else if (size == 1) return kelimeler[0];

            Arrays.sort(kelimeler);

            int end = Math.min(kelimeler[0].length(), kelimeler[size-1].length());

            for(int i=0; i<end; ){

            }
        }*/

    }
