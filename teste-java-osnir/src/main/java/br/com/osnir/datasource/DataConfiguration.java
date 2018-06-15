package br.com.osnir.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
		
	// Carragando os dados em um banco de dados em memória.
	   @Bean
	    public DataSource dataSource(){
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.h2.Driver");
	        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
	        dataSource.setUsername("sa");
	        dataSource.setPassword("sa");
	        return dataSource;
	    }
	   
	   @Bean
	   public JpaVendorAdapter jpaVendorAdapter(){
		   HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		   adapter.setDatabase(Database.H2);
		   adapter.setShowSql(true);
		   adapter.setGenerateDdl(true);
		   adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
		   adapter.setPrepareConnection(true);;
		   return adapter;
	   }
	   
}
