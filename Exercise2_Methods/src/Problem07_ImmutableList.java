import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bludya on 29.6.2016 г..
 * All rights reserved!
 */
class ImmutableList {
    private List<Integer> numbers;

    public ImmutableList() {
        numbers = new ArrayList<>();
    }

    public ImmutableList getList (){
        return new ImmutableList();
    }
}

public class Problem07_ImmutableList {
    public static void main(String[] args) throws IOException {
        Class listClass = ImmutableList.class;
        java.lang.reflect.Field[] fields = listClass.getDeclaredFields();
        if (fields.length < 1) {
            throw new ClassFormatException();
        }

        Method method = listClass.getDeclaredMethods()[0];
        System.out.println(method.getReturnType().getSimpleName());

    }
}
