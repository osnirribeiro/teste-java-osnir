package br.com.osnir;

import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;

import br.com.osnir.models.Matches;
import br.com.osnir.models.Wrangle;
import br.com.osnir.services.MatchesService;
import br.com.osnir.services.WrangleService;



@SpringBootApplication
public class ApplicationLoadJsonFiles {
	
	 private static final Logger logger = LogManager.getLogger(ApplicationLoadJsonFiles.class);

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLoadJsonFiles.class, args);
		logger.debug(" ****** Application Started ******");
	}


	// 1. Carregar histórico de partidas a partir dos arquivos .json
	@Bean
	CommandLineRunner runner(WrangleService wrangleService , MatchesService matchesService  ){
		return Args ->{
			
			JsonFactory jf = new JsonFactory();
			JsonParser jp = null;
			
			logger.debug(" Started to load JsonFiles in DataBase");

			try (FileInputStream fisWrangle = new FileInputStream("wrangle.json")) {

				jp = jf.createParser(fisWrangle);
				jp.setCodec(new ObjectMapper());
				jp.nextToken();
				while (jp.hasCurrentToken()) {
					Wrangle	wrangle = jp.readValueAs(Wrangle.class);
					jp.nextToken();
					wrangleService.create(wrangle);	        
				}
			}catch (Exception e) {
				logger.error( "Error load wrangle.json" , e.fillInStackTrace());

			}

			try (FileInputStream fisMatches = new FileInputStream("matches.json")) {
				jp = jf.createParser(fisMatches);
				jp.setCodec(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false));
				jp.nextToken();
				while (jp.hasCurrentToken()) {
					Matches	matches = jp.readValueAs(Matches.class); // Algoritimo nao trata do problema "Duplicate Key" 		
					jp.nextToken();
					matchesService.create(matches);	            
				}
			}catch (Exception e) {
				logger.error( "Error load matches.json" , e.fillInStackTrace());
			}

			logger.debug(" End to load JsonFiles in DataBase");
		};	
	}
}