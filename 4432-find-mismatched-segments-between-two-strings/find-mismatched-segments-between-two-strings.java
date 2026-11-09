class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        int n = s1.length();
        int i = 0;
        List<List<String>> list = new ArrayList<>();

        while (i < n) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                int start = i;

                while (i < n && s1.charAt(i) != s2.charAt(i)) {
                    i++;
                }

                String part1 = s1.substring(start, i);
                String part2 = s2.substring(start, i);

                list.add(Arrays.asList(part1, part2));
            }
        }

        return list;
    }
}