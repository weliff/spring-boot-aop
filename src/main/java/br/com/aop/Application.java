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
        
        try {
            repository.listar();
        } catch (IllegalStateException e) { 
            System.out.println("capturado a nova exeção do aspecto com a mensagem = " + e.getMessage());
        }
        repository.salvar(new Object());
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }


}
