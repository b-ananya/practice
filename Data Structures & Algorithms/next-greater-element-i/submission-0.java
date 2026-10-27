class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            numToIndex.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                int index = numToIndex.get(stack.peek());
                res[index] = nums2[i];
                stack.pop();
            }

            if (numToIndex.containsKey(nums2[i])) {
                stack.push(nums2[i]);
            }
        }

        return res;
    }
}