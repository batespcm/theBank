package com.bankofjava.javabank;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Lee's Java Bank",
                description = "A Little Java Bank back end to practice Java RestAPI development",
                version = "1.0"
        ),
        externalDocs = @ExternalDocumentation(
                description = "Lee's Java Bank External Documentation",
                url = "https://github.com/batespcm/theBank"
        )
)
public class JavaBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaBankApplication.class, args);
    }
}
