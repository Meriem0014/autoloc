package tn.esprit.autoloc.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j // pour utiliser la journalisation
public class LoggingAspect {
    // advice execute avant chaque methode
    @Before("execution(* tn.esprit.autoloc.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        // getSignature get le nom
        String methoName = joinPoint.getSignature().getName();

        Object[] parametres = joinPoint.getArgs();

        log.info("Before -metho appele : "+ methoName );
    }
}
