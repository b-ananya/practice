class Solution {

    public int compress(char[] chars) {
        int last = 0;
        String s = "";

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[last]) {
                s += chars[last];

                if (last + 1 != i) {
                    s += i - last;
                }

                last = i;
            }
        }

        s += chars[chars.length - 1];
        if (last + 1 <= chars.length - 1) {
            s += chars.length - last;
        }

        for (int k = 0; k < s.length(); k++) {
            chars[k] = s.charAt(k);
        }

        return s.length();
    }
}