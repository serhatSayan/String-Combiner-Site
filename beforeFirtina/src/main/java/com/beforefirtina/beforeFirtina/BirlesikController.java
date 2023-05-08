package com.beforefirtina.beforeFirtina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/birlesik")
@CrossOrigin(origins = "http://localhost:3000")
public class BirlesikController {
    @Autowired
    private BirlesikService birlesikService;

    @Autowired
    private GirdiService girdiService;

    @GetMapping("/last")
    public ResponseEntity<Optional<BirlesikMetinDoc>> getLastBirlesik() {
        return new ResponseEntity<Optional<BirlesikMetinDoc>>(birlesikService.lastBirlesik(), HttpStatus.OK);
    }

    @GetMapping("/birlestir")
    public ResponseEntity<Optional<BirlesikMetinDoc>> birlestirGirdileri() {

        List<GirdiMetinDoc> allGirdiler = girdiService.allGirdi();

        List<String> girdiler = new ArrayList<String>();
        for (GirdiMetinDoc girdi : allGirdiler) {
            girdiler.add(girdi.getGirdiMetin());
        }


        return new ResponseEntity<Optional<BirlesikMetinDoc>>(birlesikService.createBirlesikDoc(girdiler), HttpStatus.OK);
    }
}
