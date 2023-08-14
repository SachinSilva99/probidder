package lk.probidder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@SpringBootApplication
public class ProbidderApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ProbidderApplication.class, args);
    }

    //	http://localhost:8000/swagger-ui/index.html
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(xmlConverter());
    }

    @Bean
    public MappingJackson2XmlHttpMessageConverter xmlConverter() {
        return new MappingJackson2XmlHttpMessageConverter();
    }
}
