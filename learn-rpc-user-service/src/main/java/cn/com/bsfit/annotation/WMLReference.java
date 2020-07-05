package cn.com.bsfit.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wml
 * @date 2020年07月01日  10:55:52
 **/
@Target(ElementType.FIELD) //作用范围， FIELD表示修饰在字段上。
@Retention(RetentionPolicy.RUNTIME) //注解的保留时间， 因为我需要在运行时用到，所以定义runtime在运行时保留
@Component //表示需要被spring扫描到的注解。
public @interface WMLReference {
}
