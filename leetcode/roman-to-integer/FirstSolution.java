class Solution {

    static Map<Character, Integer> MAP = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    public int romanToInt(String s) {
        
        List<String> splitted = new ArrayList<>();
        String tmp = "";

        for (int i = s.length() - 1; i >= 0; --i) {
            char c = s.charAt(i);

            if (i == s.length() - 1) {
                tmp = c + "";
                continue;
            }

            if (MAP.get(tmp.charAt(0)) > MAP.get(c)) {
                tmp = c + tmp;
            } else {
                splitted.add(tmp);
                tmp = c + "";
            }
        }

        if (!tmp.isEmpty()) {
            splitted.add(tmp);
        }

        Collections.reverse(splitted);

        int answer = 0;
        for (String str : splitted) {
            int ans = 0;
            for (int i = str.length() - 1; i >= 0; --i) {
                char c = str.charAt(i);

                if (i == str.length() - 1) {
                    ans += MAP.get(c);
                } else {
                    if (MAP.get(c) >= MAP.get(str.charAt(i+1))) {
                        ans += MAP.get(c);
                    } else {
                        ans -= MAP.get(c);
                    }
                }
            }

            answer += ans;
        }
        return answer;
    }
}
