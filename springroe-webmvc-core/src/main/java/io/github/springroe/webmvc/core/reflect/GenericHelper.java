package io.github.springroe.webmvc.core.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class GenericHelper {

    public static Class<?> getGenericClass(Class<?> implClass, int index) {

        TypeVariable<? extends Class<?>>[] typeParameters = implClass.getTypeParameters();

        Type genericSuperclass = implClass.getGenericSuperclass();

        Type[] genericInterfaces = implClass.getGenericInterfaces();
        //com...CustomService<
        // 					java.util.List<java.util.Map<java.lang.String, java.lang.Integer>>
        // 					, com...BaseService<java.util.Set>
        //					>
        return GenericHelper.class;
    }

}
