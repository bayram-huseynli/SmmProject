package com.example.smmproject.repository;

import com.example.smmproject.entity.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AboutUsRepository extends JpaRepository<AboutUs,Long> {


}
