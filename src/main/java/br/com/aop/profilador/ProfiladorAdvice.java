package br.com.aop.profilador;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfiladorAdvice {
    
    @Around("execution(* br.com.aop.*.*(..))")
    public Object profilar(ProceedingJoinPoint joinPoint) throws Throwable {
        long tempoInicio = System.currentTimeMillis();
        
        Object resultado = joinPoint.proceed();
        
        long tempoFim = System.currentTimeMillis();
        System.out.println("Tempo gasto para executar = " + (tempoFim - tempoInicio) + "ms");
        
        return resultado;
    }

}
