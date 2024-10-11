package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastOpen = stack.pop();
                if ((c == '}' && lastOpen != '{'))
                    return false;
                else if(c == ']' && lastOpen != '[')
                    return false;
                else if(c == ')' && lastOpen != '(')
                    return false;
                }
            }

        return stack.isEmpty();
    }

}
