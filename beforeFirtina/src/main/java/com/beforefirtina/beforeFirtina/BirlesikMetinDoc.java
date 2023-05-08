package com.beforefirtina.beforeFirtina;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "BirlesikMetinler")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BirlesikMetinDoc {
    @Id
    private ObjectId id;
    private String birlesikMetin;
    private double sure;

    //Birleşik metin dökümanı girdilerin referansını barındırmak isterse
    //@DocumentReference
    //private List<GirdiMetinDoc> girdiMetinIdleri;
}
