package test7.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/6/18
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomFieldAnno {

    public String id ();

    public String description() default "no description";

}
