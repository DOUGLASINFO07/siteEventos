/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimtechApp.dimtechApp;



import java.net.URI;
import java.net.URISyntaxException;
import org.apache.commons.dbcp2.BasicDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 *
 * @author douglas borges egidio
 * @author DouglasInfo07.
 */

@Configuration
public class DataConfiguration {
    
     @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
    
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://javaweb.mysql.uhserver.com/javaweb?useTimezone=true&serverTimezone=UTC");
//        dataSource.setUsername("javaweb");
//        dataSource.setPassword("030182.Dtb");
//        return dataSource;
//
//    }
//	
//	@Bean
//	public JpaVendorAdapter jpaVendorAdapter(){
//		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		adapter.setDatabase(Database.MYSQL);
//		adapter.setShowSql(true);
//		adapter.setGenerateDdl(true);
//                
//                //Testar uma das três setDatabasePlatform.
//		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
////		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLMyISAMDialect");
////		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLInnoDBDialect");
//                
//		adapter.setPrepareConnection(true);
//		return adapter;
//	}
//=======
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
///**
// *
// * @author douglas borges egidio
// * @author DouglasInfo07.
// */
//
//@Configuration
//public class DataConfiguration {
//    
//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://javaweb.mysql.uhserver.com/javaweb?useTimezone=true&serverTimezone=UTC");
//        dataSource.setUsername("javaweb");
//        dataSource.setPassword("030182.Dtb");
//        return dataSource;
//
//    }
//	
//	@Bean
//	public JpaVendorAdapter jpaVendorAdapter(){
//		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		adapter.setDatabase(Database.MYSQL);
//		adapter.setShowSql(true);
//		adapter.setGenerateDdl(true);
//                
//                //Testar uma das três setDatabasePlatform.
//		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
////		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLMyISAMDialect");
////		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLInnoDBDialect");
//                
//		adapter.setPrepareConnection(true);
//		return adapter;
//	}

}
