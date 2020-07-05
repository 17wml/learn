package cn.com.bsfit.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wml
 * @date 2020年07月01日  9:28:45
 **/
@Target(ElementType.TYPE) //作用范围， type表示可以描述类，接口，枚举层面
@Retention(RetentionPolicy.RUNTIME) //注解的保留时间， 因为我需要在运行时用到，所以定义runtime在运行时保留
@Component //表示需要被spring扫描到的注解。
public @interface WMLRemoteService {
}
