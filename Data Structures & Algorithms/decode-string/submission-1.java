public class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                StringBuilder substr = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    substr.insert(0, stack.pop());
                }
                stack.pop();

                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k.insert(0, stack.pop());
                }
                int count = Integer.parseInt(k.toString());
                String repeatedStr = substr.toString().repeat(count);
                stack.push(repeatedStr);
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}