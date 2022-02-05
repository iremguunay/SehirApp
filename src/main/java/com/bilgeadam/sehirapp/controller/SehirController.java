package com.bilgeadam.sehirapp.controller;

import com.bilgeadam.sehirapp.entity.Sehir;
import com.bilgeadam.sehirapp.exception.SehirNotFound;
import com.bilgeadam.sehirapp.repository.SehirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SehirController {

    @Autowired
    private SehirRepository sehirRepository;

    @GetMapping("/sehir/{id}")
    public Sehir getSehir(@PathVariable("id") long sehirNo) {

        Sehir sehir = null;

        Optional<Sehir> sehirDB = sehirRepository.findById(sehirNo);

        if (sehirDB.isPresent()) {
            sehir = sehirDB.get();
            return sehir;
        } else {
            throw new SehirNotFound(sehirNo + " no'lu Şehir bulunamadı.");
        }
    }

    @GetMapping("/sehir")
    public List<Sehir> getSehirList() {

        return sehirRepository.findAll();
    }

    @GetMapping("/sehir-ad/{id}")
    public String getSehirAd(@PathVariable("id") long no) {

        return getSehir(no).getAd();
    }
}
