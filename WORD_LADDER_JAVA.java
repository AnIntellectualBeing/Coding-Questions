import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                char[] charArray = currentWord.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char originalChar = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != originalChar) {
                            charArray[j] = c;
                            String newWord = new String(charArray);

                            if (newWord.equals(endWord))
                                return level + 1;

                            if (wordSet.contains(newWord)) {
                                queue.offer(newWord);
                                wordSet.remove(newWord);
                            }
                        }
                    }
                    charArray[j] = originalChar;
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String beginWord = scanner.next();
        String endWord = scanner.next();

        int n = scanner.nextInt();
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            wordList.add(scanner.next());
        }

        Solution solution = new Solution();
        int result = solution.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);

        scanner.close();
    }
}
