package com.hendisantika.springbootuploadmultiplefiletomysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
        SpringbootUploadMultipleFileToMysqlApplication.class,
        Jsr310JpaConverters.class
})
public class SpringbootUploadMultipleFileToMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootUploadMultipleFileToMysqlApplication.class, args);
    }

    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Jakarta"));
    }

}
