package br.com.project.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.project.bookstore.service.DBServicce;

@Configuration
@Profile("teste")
public class TestConfig {

    @Autowired
    private DBServicce dbService;

    public void databaseInstance(){
        this.dbService.databaseInstance();
    }

}
