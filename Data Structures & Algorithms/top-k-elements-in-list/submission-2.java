class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // min heap method: create a frequency map O(n)
        // then add all frequencies, num to it
        // poll if the size greater than k
        // poll at end and save to k-length array


        // bucket sort method:
        // create a map of frrquencies and then add
        // all the values to its a list of the values
        // that have the index's frequency
        // then go throught he list backwards til you get k elements
        
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
        
    }
}
