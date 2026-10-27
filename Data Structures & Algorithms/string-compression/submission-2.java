class Solution {
    public int compress(char[] chars) {

        int k = 0; // space to write to next
        int i = 1; // character to read next
        int count = 1;

        while (i < chars.length) {

            if (chars[i] != chars[i-1]) {
                // add char
                chars[k++] = chars[i-1];

                // update count
                if (count > 1) {
                    String num = Integer.toString(count);
                    for (char c : num.toCharArray()) {
                        chars[k++] = c;
                    }
                    count = 1;
                }
            } else {
                count++;
            }
            i++;
        }

        chars[k++] = chars[chars.length - 1];
        if (count > 1) {
            String num = Integer.toString(count);
            for (char c : num.toCharArray()) {
                chars[k++] = c;
            }
        }

        return k;
        
    }
}