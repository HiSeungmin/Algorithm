from collections import deque

def solution(begin, target, words):
    answer = -1

    if target not in words:
        return 0

    visited=[0]*(len(words))
    
    q = deque()
    q.append(begin)

    while q:
        w = q.popleft()
        k = words.index(w) if begin!=w else 0
        for i in range(len(words)):
            if visited[i] != 0:
                continue
            cnt = 0
            for j in range(len(w)):
                if words[i][j] != w[j]:
                    cnt+=1
            if cnt == 1: # 한글자만 다르다면
                q.append(words[i])
                visited[i] = visited[k]+1        

    return visited[words.index(target)]