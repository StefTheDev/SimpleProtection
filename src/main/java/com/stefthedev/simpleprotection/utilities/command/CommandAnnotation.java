package com.stefthedev.simpleprotection.utilities.command;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface CommandAnnotation {

    String name();
    String[] aliases() default {};
    int length() default 1;
}
