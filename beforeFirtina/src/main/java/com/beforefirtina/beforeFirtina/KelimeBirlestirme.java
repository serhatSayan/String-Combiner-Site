package com.beforefirtina.beforeFirtina;

import java.util.ArrayList;
import java.util.List;

public class KelimeBirlestirme {

    //bu algoritmayı listeye uygun hale getirmemiz lazım

    public static void main(String[] args) {
        List<String> testGirdiler = new ArrayList<String>();
        testGirdiler.add("yekta");
        testGirdiler.add("test2");
        testGirdiler.add("test3");
        testGirdiler.add("test4");

        System.out.println(kelimeBirlestir(testGirdiler));
    }

        public static BirlesikMetinDoc kelimeBirlestir(List<String> girdiler){

            long startTime = System.nanoTime();

            //null kontrolü yapılmalı
            String metin1 = girdiler.get(0);


            //sa
            char[] WordOneArray = metin1.toCharArray();
            int kademe = 2;
            String str = "";


            for (int sira=1; sira<girdiler.size(); sira++) {


                String metin2 = girdiler.get(sira);
                ArrayList<Character> finalCombination = new ArrayList<Character>();
                int sayac = 0;
                kademe++;
                char[] WordTwoArray = metin2.toCharArray();
                char[] FinalCombinationArray = new char[WordOneArray.length + WordTwoArray.length];
                List<Character> BirlesikArray = new ArrayList<Character>();
                if(metin2.equals("e")) {
                    break;
                }


                if (WordOneArray.length >= WordTwoArray.length) {
                    for (int i = 0; i < WordOneArray.length; i++) {
                        for (int j = 0; j < WordTwoArray.length; j++) {
                            if (WordOneArray[i] == WordTwoArray[j] && i == j) {
                                // if(WordOneArray[i] != ' ' || WordTwoArray[j] != ' ') {
                                FinalCombinationArray[i] = WordOneArray[i];
                                finalCombination.add(FinalCombinationArray[i]);
                                i++;
                                sayac++;
                                /*
                                 * benzerlik1++; if(benzerlik1>benzerlik2) { benzerlik2=benzerlik1; continue; }
                                 * else if (benzerlik1<=benzerlik2) { System.out.println((finalCombination)); }
                                 */

                                // }
                            } else {
                                break;
                            }

                        }
                    }
                } else {
                    for (int i = 0; i < WordTwoArray.length; i++) {
                        for (int j = 0; j < WordOneArray.length; j++) {
                            if (WordTwoArray[i] == WordOneArray[j] && i == j) {
                                // if(WordOneArray[i] != ' ' || WordTwoArray[j] != ' ') {
                                FinalCombinationArray[i] = WordTwoArray[i];
                                finalCombination.add(FinalCombinationArray[i]);
                                i++;
                                sayac++;
                                /*
                                 * benzerlik1++; if(benzerlik1>benzerlik2) { benzerlik2=benzerlik1; continue; }
                                 * else if (benzerlik1<=benzerlik2) { System.out.println((finalCombination)); }
                                 */

                                // }
                            } else {
                                break;
                            }

                        }

                    }

                }

                BirlesikArray.addAll(finalCombination);

                // finalCombination.add(WordOneArray[birlesikKarakterIndex]);
                for (int i = sayac; i < WordOneArray.length; i++) {
                    BirlesikArray.add(WordOneArray[i]);
                }
                for (int j = sayac; j < WordTwoArray.length; j++) {
                    BirlesikArray.add(WordTwoArray[j]);
                }
                System.out.println(sayac);
                //System.out.println(BirlesikArray);
                StringBuilder convertStr = new StringBuilder();
                for (Character xvb : BirlesikArray) {
                    convertStr.append(xvb);
                }

                str = convertStr.toString();

                WordOneArray = str.toCharArray();
            }
            System.out.println(str);

            BirlesikMetinDoc birlesikMetinObjesi = new BirlesikMetinDoc();
            birlesikMetinObjesi.setBirlesikMetin(str);
            birlesikMetinObjesi.setSure((System.nanoTime()-startTime)/1000000000.0);

            return birlesikMetinObjesi;
        }
}
