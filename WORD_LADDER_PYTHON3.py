from collections import deque

def ladderLength(beginWord, endWord, wordList):
    wordSet = set(wordList)
    if endWord not in wordSet:
        return 0

    ans = 0
    q = deque([beginWord])

    while q:
        ans += 1
        for _ in range(len(q)):
            wordList = list(q.popleft())
            for i, cache in enumerate(wordList):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    wordList[i] = c
                    word = ''.join(wordList)
                    if word == endWord:
                        return ans + 1
                    if word in wordSet:
                        q.append(word)
                        wordSet.remove(word)
                wordList[i] = cache

    return 0

if __name__ == "__main__":
    beginWord = input().strip()
    endWord = input().strip()
    n = int(input().strip())
    wordList = [input().strip() for _ in range(n)]

    result = ladderLength(beginWord, endWord, wordList)
    print(result)
