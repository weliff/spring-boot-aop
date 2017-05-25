package br.com.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryAspect {
    
    @Around("execution(* br.com.aop.repository.*.*(java.lang.Object)) || execution(* br.com.aop.repository.*.*(..))")
    public Object profilarAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long tempoInicio = System.currentTimeMillis();
        
        Object resultado = joinPoint.proceed();
        
        String nomeMetodo = joinPoint.getSignature().getName();
        String argumentos = Arrays.toString(joinPoint.getArgs());
        
        long tempoFim = System.currentTimeMillis();
        System.out.println(String.format("Tempo gasto para executar o método '%s' com os parametros '%s' = %d ms", nomeMetodo, argumentos, tempoFim - tempoInicio));
        
        return resultado;
    }
    
    @Before("execution(void br.com.aop.*.*.salvar(..))")
    public void verificarParametroAdvice(JoinPoint joinPoint) {
        System.out.println("parametro recebido >>> " + joinPoint.getArgs()[0]);
    }

    @AfterThrowing(pointcut="execution(* br.com.aop.*.*.listar())", throwing = "ex")
    public void recuperarErroAdvice(RuntimeException ex) {
        System.out.println("lançou um erro");
        throw new IllegalStateException("re-throw");
    }
}
