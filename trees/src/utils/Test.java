package utils;

import diameter_of_binary_tree.Solution;
import model.TreeNode;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Test {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        --add-opens java.base/java.lang.reflect=ALL-UNNAMED

        Solution.MyClass test = new Solution.MyClass(new TreeNode(1));
        Field field = Solution.MyClass.class.getDeclaredField("client");
        ((Field) field).setAccessible(true); // NOPMD
        int modifiers = field.getModifiers();
//        if (Modifier.isFinal(field.getModifiers())) {
//
//            MethodHandles.Lookup lookup = MethodHandles.privateLookupIn(Field.class, MethodHandles.lookup());
//            VarHandle modifiers = lookup.findVarHandle(Field.class, "modifiers", int.class);
//            modifiers.set(field, field.getModifiers() & ~Modifier.FINAL);
//        }
        field.set(test, new TreeNode(2));
        System.out.println(test.getClient().val);
    }
}
