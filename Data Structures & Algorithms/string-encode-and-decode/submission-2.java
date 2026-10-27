class Solution {

    public String encode(List<String> strs) {
        // store each string with the length right before
        // some symbol to designate a new string and length combo
        // can't split anytime you see a #: since # might appear in a string
        // that's why need length and # combo

        // length#stringlength#string...

        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            res.append(length).append("#").append(str);
        }
        return res.toString();

    }

    public List<String> decode(String str) {

        List<String> strs = new ArrayList<>();
        int prev = 0;
        int cur = 1;

        while (cur < str.length()) {
            if (str.charAt(cur) != '#') {
                cur++;
            } else {
                int length = Integer.parseInt(str.substring(prev, cur));
                strs.add(str.substring(cur+1, cur+1+length));
                prev = cur + 1 + length;
                cur = cur + 2 + length;
            }
        }

        return strs;

    }
}
