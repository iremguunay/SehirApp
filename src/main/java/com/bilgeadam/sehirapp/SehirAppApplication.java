package com.bilgeadam.sehirapp;

import com.bilgeadam.sehirapp.entity.Sehir;
import com.bilgeadam.sehirapp.repository.SehirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SehirAppApplication implements CommandLineRunner {

    @Autowired
    private SehirRepository sehirRepository;

    public static void main(String[] args) {
        SpringApplication.run(SehirAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Sehir sehir1 = new Sehir();
        sehir1.setAd("Mardin");

        Sehir sehir2 = new Sehir();
        sehir2.setAd("Ankara");

        Sehir sehir3 = new Sehir();
        sehir3.setAd("Samsun");

        sehirRepository.save(sehir1);
        sehirRepository.save(sehir2);
        sehirRepository.save(sehir3);

    }
}
