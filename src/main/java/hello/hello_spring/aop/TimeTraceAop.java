package hello.hello_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component  // 이렇게 빈을 생성하는 방법이 있고 config에서 주입 생성하고 주입받는 방식이 있다.
public class TimeTraceAop {


    @Around("execution(* hello.hello_spring..*(..))")      // hello_spring 하위 클래스들에 모두 적용해
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint + " " + timeMs + "ms");
        }
    }
}
