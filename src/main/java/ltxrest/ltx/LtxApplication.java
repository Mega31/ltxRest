package ltxrest.ltx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@PersistenceContext(type = PersistenceContextType.EXTENDED)
@SpringBootApplication
public class LtxApplication {

    public static void main(String[] args) {
        SpringApplication.run(LtxApplication.class, args);
    }

}
