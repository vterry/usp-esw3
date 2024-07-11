package br.com.pecepoli.demo.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("br.com.pecepoli.demo.domain")
@EnableJpaRepositories(basePackages = "br.com.pecepoli.demo.repository")
public class JpaConfig {

}
