package shan.utils;

import io.github.mtrevisan.boxon.annotations.bindings.ByteOrder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface BindEnum {
    String size();

    Class<? extends ByteEnum> type();

    ByteOrder byteOrder() default ByteOrder.BIG_ENDIAN;
}
