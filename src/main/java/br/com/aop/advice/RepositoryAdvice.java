package br.com.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryAdvice {
    
    @Around("execution(* br.com.aop.repository.*.*(java.lang.Object))")
    public Object profilar(ProceedingJoinPoint joinPoint) throws Throwable {
        long tempoInicio = System.currentTimeMillis();
        
        Object resultado = joinPoint.proceed();
        
        long tempoFim = System.currentTimeMillis();
        System.out.println("Tempo gasto para executar = " + (tempoFim - tempoInicio) + "ms");
        
        return resultado;
    }
    
    @Before("execution(void br.com.aop.*.*.salvar(..))")
    public void verificarParametro(JoinPoint joinPoint) {
        System.out.println("parametro recebido >>> " + joinPoint.getArgs()[0]);
    }

    @AfterThrowing(pointcut="execution(* br.com.aop.*.*.listar())", throwing = "ex")
    public void recuperarErro(RuntimeException ex) {
        System.out.println("lançou um erro");
    }
}
