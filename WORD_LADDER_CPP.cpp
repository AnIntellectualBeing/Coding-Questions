#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
#include <queue>

using namespace std;

int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
    unordered_set<string> wordSet(wordList.begin(), wordList.end());
    if (!wordSet.count(endWord))
        return 0;

    int ans = 0;
    queue<string> q{{beginWord}};

    while (!q.empty()) {
        ++ans;
        for (int sz = q.size(); sz > 0; --sz) {
            string word = q.front();
            q.pop();
            for (std::string::size_type i = 0; i < word.length(); ++i) {
                char cache = word[i];
                for (char c = 'a'; c <= 'z'; ++c) {
                    word[i] = c;
                    if (word == endWord)
                        return ans + 1;
                    if (wordSet.count(word)) {
                        q.push(word);
                        wordSet.erase(word);
                    }
                }
                word[i] = cache;
            }
        }
    }

    return 0;
}

int main() {
    string beginWord;
    cin >> beginWord;

    string endWord;
    cin >> endWord;

    int n;
    cin >> n;

    vector<string> wordList(n);
    for (int i = 0; i < n; i++) {
        cin >> wordList[i];
    }

    int result = ladderLength(beginWord, endWord, wordList);
    cout << result << endl;

    return 0;
}
