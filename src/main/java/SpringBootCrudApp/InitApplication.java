package SpringBootCrudApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
/*@ComponentScan(basePackages = "SpringBootCrudApp.config")
@Import({UserDaoImp.class , RoleDaoImpl.class})*/
public class InitApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(InitApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure( SpringApplicationBuilder application) {
        return application.sources(InitApplication.class);
    }

}