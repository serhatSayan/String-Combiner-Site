package com.beforefirtina.beforeFirtina;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "GirdiMetinler")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GirdiMetinDoc {
    @Id
    private ObjectId id;
    private String girdiMetin;
}
