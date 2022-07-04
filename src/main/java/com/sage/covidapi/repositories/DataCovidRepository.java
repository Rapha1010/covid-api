package com.sage.covidapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sage.covidapi.entities.DataCovid;

public interface DataCovidRepository extends JpaRepository<DataCovid, Long> {

}
