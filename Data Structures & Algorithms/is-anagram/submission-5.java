class Solution {
    public boolean isAnagram(String s, String t) {
        return getMap(s).equals(getMap(t));

    }

    public Map<Character, Integer> getMap (String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
