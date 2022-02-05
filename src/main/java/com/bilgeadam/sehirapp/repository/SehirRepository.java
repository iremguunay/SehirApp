package com.bilgeadam.sehirapp.repository;

import com.bilgeadam.sehirapp.entity.Sehir;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SehirRepository extends JpaRepository<Sehir, Long> {
}
