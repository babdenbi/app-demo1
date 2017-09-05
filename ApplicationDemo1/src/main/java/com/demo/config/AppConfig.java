package com.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.demo.model.User;

@Configuration
@ComponentScan ("com.demo")
@EnableTransactionManagement
public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		bds.setUrl("jdbc:sqlserver://localhost:1433;databaseName = BANKALMAGHRIB");
		bds.setUsername("sa");
		bds.setPassword("Enimbam0477");
		
		return bds;
		
	}
	
	@Bean 
	public SessionFactory sessionFactory() {
		
		LocalSessionFactoryBuilder builder =
				new LocalSessionFactoryBuilder(dataSource());
		//builder.addPackage("com.demo.model");
		  builder.addAnnotatedClass(User.class);
		builder.addProperties(getProps());
		
		return builder.buildSessionFactory();
		
	}
	
	private Properties getProps () {
		Properties props = new Properties ();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		props.setProperty("hibernate.show_sql", "true");
		
		return props;
		
	}

	@Bean (name = "transactionManager")
	
	public HibernateTransactionManager transactionManager() {
		
		 return new HibernateTransactionManager(sessionFactory());
		
	}
	
	@Bean 
	
	public HibernateTemplate getHibernateTemplate() 
    {
		return  new HibernateTemplate(sessionFactory ());
	}
}
