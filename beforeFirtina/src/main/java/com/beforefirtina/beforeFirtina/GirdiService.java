package com.beforefirtina.beforeFirtina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirdiService {

    @Autowired
    private GirdiRepository girdiRepository;

    public List<GirdiMetinDoc> allGirdi(){
        return girdiRepository.findAll();
    }

    public List<GirdiMetinDoc> postGirdiler(List<GirdiMetinDoc> girdiler){
        return girdiRepository.insert(girdiler);
    }
}
