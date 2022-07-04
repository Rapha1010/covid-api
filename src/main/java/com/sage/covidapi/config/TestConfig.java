package com.sage.covidapi.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.sage.covidapi.entities.DataCovid;
import com.sage.covidapi.repositories.DataCovidRepository;


@Configuration
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private DataCovidRepository dataCovid;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		loadingDataTable();
	}
	
	public void loadingDataTable() {
		
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
			pessoas = csvReader.readAll().subList(0, 1000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<DataCovid> DataCovidContainer = new ArrayList();
		
        for (String[] pessoa : pessoas) {
        	
        	String date = pessoa[0];
        	String uf = pessoa[1];
        	String city = pessoa[3];
        	Integer confirmed = Integer.parseInt(pessoa[4]);
        	Integer deaths = Integer.parseInt(pessoa[5]);
        	Integer estimated_population = Integer.parseInt(pessoa[6]);
        	
        	DataCovid dtc = new DataCovid(date,uf,city, confirmed, deaths, estimated_population);		
        	
        	DataCovidContainer.add(dtc);
        }
        
        dataCovid.saveAll(DataCovidContainer);
	}

}
