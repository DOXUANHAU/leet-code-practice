package string;

import java.util.*;
class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();

    // Edge case: nếu input không hợp lệ thì return luôn
    if (s == null || s.length() == 0 || words.length == 0) return result;

    // Độ dài mỗi word
    int wordLen = words[0].length();

    // Số lượng words
    int wordCount = words.length;

    // Tổng độ dài cần match
    // int totalLen = wordLen * wordCount;

    // Map lưu số lần xuất hiện của mỗi word trong words
    Map<String, Integer> wordMap = new HashMap<>();
    for (String w : words) {
        wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
    }

    // Loop theo offset (0 -> wordLen - 1)
    // Vì ta duyệt theo block wordLen nên phải thử các điểm bắt đầu khác nhau
    for (int i = 0; i < wordLen; i++) {

        int left = i; // con trỏ trái của window
        int count = 0; // số word hợp lệ hiện tại trong window

        // Map lưu số lần xuất hiện của word trong window hiện tại
        Map<String, Integer> windowMap = new HashMap<>();

        // Duyệt chuỗi s, mỗi lần nhảy wordLen
        for (int j = i; j + wordLen <= s.length(); j += wordLen) {

            // Lấy substring có độ dài = wordLen
            String word = s.substring(j, j + wordLen);

            // Nếu word nằm trong danh sách words
            if (wordMap.containsKey(word)) {

                // Thêm word vào window
                windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                count++;

                // Nếu word bị dư (xuất hiện nhiều hơn trong wordMap)
                // thì phải thu nhỏ window từ bên trái
                while (windowMap.get(word) > wordMap.get(word)) {

                    // Lấy word ở vị trí left
                    String leftWord = s.substring(left, left + wordLen);

                    // Giảm count của word đó trong window
                    windowMap.put(leftWord, windowMap.get(leftWord) - 1);

                    // Dịch left sang phải
                    left += wordLen;
                    count--;
                }

                // Nếu đủ số lượng word cần thiết → tìm được kết quả
                if (count == wordCount) {
                    result.add(left);

                    // Sau khi add, tiếp tục trượt window
                    String leftWord = s.substring(left, left + wordLen);
                    windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }

            } else {
                // Nếu word không hợp lệ → reset window
                windowMap.clear();
                count = 0;
                left = j + wordLen;
            }
        }
    }

    return result;
}

}