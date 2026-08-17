class Solution {
            public record Pair(int  x, int y) {}

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Pair> deque = new ArrayDeque<>();
    int[] ans = new int[nums.length - k +1];

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekFirst().x() < nums[i]) {
                deque.removeFirst();
            }
            deque.addFirst(new Pair(nums[i], i));
            ans[0] = (deque.peekLast().x());
        }

        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst().x() < nums[i]) {
                deque.removeFirst();
            }
            deque.addFirst(new Pair(nums[i], i));
            if (deque.peekLast().y == i - k) {
                deque.removeLast();
            }
            ans[i-k +1]=(deque.peekLast().x());
        }
        return ans ;
    }
}
