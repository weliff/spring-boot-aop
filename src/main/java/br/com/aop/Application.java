package br.com.aop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.aop.repository.ClientesRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ClientesRepository repository;
    
    public void run(String... arg0) throws Exception {
        repository.salvar(new Object());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


}
