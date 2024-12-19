package br.com.project.bookstore.config;

import br.com.project.bookstore.service.DBServicce;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    private DBServicce dbServicce;

    @Value("$(spring.jpa.hibernate.ddl-auto)")
    private String strategy;

    public boolean databaseInstance(){
        if (strategy.equals("create")){
            this.dbServicce.databaseInstance();
        }
        return false;
    }
}
