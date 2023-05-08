package com.beforefirtina.beforeFirtina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirlesikService {

    @Autowired
    private BirlesikRepository birlesikRepository;

    public Optional<BirlesikMetinDoc> lastBirlesik(){
        return birlesikRepository.findFirstByOrderByIdDesc();
    }

    public Optional<BirlesikMetinDoc> createBirlesikDoc(List<String> girdiler){

        //boş ve tek eleman kontrolü
        if (girdiler.size()==1 || girdiler.size()==0) return Optional.empty();

        //girdi kelimelerden mi oluşuyor cümlelerden mi kontorlü
        boolean cumleMi = false;
        for (int sira= 0; sira < girdiler.size(); sira++){
            if(1 != girdiler.get(sira).split(" ").length){
                cumleMi=true;
                break;
            }
        }

        //Buraya birleştirme işlemi gelecek
        BirlesikMetinDoc birlesikMetinDoc = new BirlesikMetinDoc();


        if(cumleMi){
            birlesikMetinDoc = CumleBirlestirme.cumleBirlesir(girdiler);
            System.out.println("Cümle");
            System.out.println(birlesikMetinDoc);
        } else {
            birlesikMetinDoc = KelimeBirlestirme.kelimeBirlestir(girdiler);
            System.out.println("Kelime");
            System.out.println(birlesikMetinDoc);
        }

        return Optional.of(birlesikRepository.insert(birlesikMetinDoc));
    }
}
