package liga.medical.messageanalyzer.core.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LogAdvice {

    Logger logger = Logger.getLogger(String.valueOf(LogAdvice.class));

    @Pointcut("@annotation(liga.medical.dto.annotations.DbLog)")
    public void loggableMethods() { }

    @Around("loggableMethods()")
    public Object serviceLogger(ProceedingJoinPoint pjp) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String id = UUID.randomUUID().toString();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString().replaceAll("class", "");
        Object[] args = pjp.getArgs();

        Object object = null;
        logger.log(Level.INFO, String.format("UUID:%s, метод:%s.%s() с аргументами %s", id, className, methodName, mapper.writeValueAsString(args)));
        try {
            object = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return object;
    }
}