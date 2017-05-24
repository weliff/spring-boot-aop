package br.com.aop.repository;
import org.springframework.stereotype.Repository;

@Repository
public class ClientesRepository {
    
    public void salvar(Object obj) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }

}
