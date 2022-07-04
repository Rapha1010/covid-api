package com.sage.covidapi;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@SpringBootApplication
public class CovidApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidApiApplication.class, args);
		
//		loadingDataTable();
	}
	
	public static void loadingDataTable() {
		
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get("caso-covid.csv"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> pessoas = null;
		try {
			pessoas = csvReader.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for (String[] pessoa : pessoas)
            System.out.println(
			"data : " + pessoa[0] +
            "uf : " + pessoa[1] +
            "city : " + pessoa[2]+
            "confirmed : " + pessoa[3]+
            "deaths : " + pessoa[4]+
            "estimated_population : " + pessoa[6]
            );
		
	}

}
