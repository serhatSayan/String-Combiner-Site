package com.beforefirtina.beforeFirtina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/girdiler")
@CrossOrigin(origins = "http://localhost:3000")
class GirdiController {

    @Autowired
    private GirdiService girdiService;

    //test
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }

    //dbde bulunan tüm girdileri getirir
    @GetMapping("/getAll")
    public ResponseEntity<List<GirdiMetinDoc>> getAllGirdi(){
        return new ResponseEntity<List<GirdiMetinDoc>>(girdiService.allGirdi(), HttpStatus.OK);
    }

    //önyüzden gelen metinleri dbye kaydeder
    @PostMapping("/postMetin")
    public ResponseEntity<List<GirdiMetinDoc>> postAllGirdi(@RequestBody List<GirdiMetinDoc> payload){
        return new ResponseEntity<List<GirdiMetinDoc>>(girdiService.postGirdiler(payload), HttpStatus.CREATED);
    }
}