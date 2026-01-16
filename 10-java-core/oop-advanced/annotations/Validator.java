package oop_advanced.annotations;

import java.lang.reflect.*;
import java.util.*;

public class Validator {

    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();

        for(Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);

            try {
                Object value = f.get(obj);

                if(f.isAnnotationPresent(NotNull.class) && value == null) {
                    errors.add(f.getAnnotation(NotNull.class).message());
                }

                if(f.isAnnotationPresent(Validate.class) && value != null) {
                    int v = (int)value;
                    Validate val = f.getAnnotation(Validate.class);
                    if(v < val.min() || v > val.max())
                        errors.add(val.message());
                }
            } catch(Exception e) {}
        }
        return errors;
    }
}
