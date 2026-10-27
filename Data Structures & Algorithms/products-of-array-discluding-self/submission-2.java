class Solution {
    public int[] productExceptSelf(int[] nums) {
        // division operation method

        int product = 1;
        int zeros = 0;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
            } else {
                product *= num;
            }
        }

        int[] output = new int[nums.length];
    
        if (zeros > 1) {
            return output;
        }

        for (int i = 0; i < output.length; i++) {
            if (nums[i] == 0) {
                output[i] = product;
                return output;
            } else if (zeros == 0) {
                output[i] = product / nums[i];
            }
        }
        return output;

    }
}  
