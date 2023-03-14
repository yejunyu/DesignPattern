package sort.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * @Author yjy
 * @Date 2023/2/1
 **/
public class Test2 {

    static Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }


    public static boolean test1(String str) {
        if (str == null || str.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsValue(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !Objects.equals(stack.peek(), map.get(c))) {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    /**
     * {()[]{}}
     * ([{}()])
     * ([)]
     * 判断是否能成对
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "{()[]{}}";
        String s2 = "([{}()])";
        String s3 = "([)]";
        System.out.println(test1(s1));
        System.out.println(test1(s2));
        System.out.println(test1(s3));

    }
}
