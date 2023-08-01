package com.rish.scratch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EnumTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Enum<?> enumeration = TypeEnum.ALL;
        Method m = enumeration.getClass().getMethod("getLiteral", null);
        String value = (String) m.invoke(enumeration, null);
        System.out.println(value);
    }
}

