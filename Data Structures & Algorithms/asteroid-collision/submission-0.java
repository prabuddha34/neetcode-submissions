class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision happens only when:
            // stack top is moving right (+)
            // current asteroid is moving left (-)

            while (!stack.isEmpty() &&
                    stack.peek() > 0 &&
                    asteroid < 0) {

                // Top asteroid is smaller
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {

                    stack.pop();
                }

                // Both same size
                else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {

                    stack.pop();
                    destroyed = true;
                    break;
                }

                // Current asteroid smaller
                else {

                    destroyed = true;
                    break;
                }
            }

            // If current asteroid survives
            if (!destroyed) {

                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] ans = new int[stack.size()];

        for (int i = ans.length - 1; i >= 0; i--) {

            ans[i] = stack.pop();
        }

        return ans;
    }
}