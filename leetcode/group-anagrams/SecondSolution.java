class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; ++i) {
            char[] charArrays = strs[i].toCharArray();
            Arrays.sort(charArrays);

            String sortedChars = new String(charArrays);

            List<Integer> indices = new ArrayList<>();
            if (map.containsKey(sortedChars)) {
                indices = map.get(sortedChars);
            }
            indices.add(i);
            map.put(sortedChars, indices);
        }

        List<List<String>> answer = new ArrayList<>();
        for (Map.Entry e : map.entrySet()) {
            List<Integer> values = (List) e.getValue();
            answer.add(values.stream()
                .map(idx -> strs[idx])
                .toList());
        }
        return answer;
    }
}
