package br.com.aop.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ClientesRepository {
    
    public void salvar(Object obj) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
    
    public List<Object> listar() {
        throw new RuntimeException();
    }

}
