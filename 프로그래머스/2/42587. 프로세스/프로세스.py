from collections import deque

def solution(priorities, location):
    q = deque()
    idx = deque()
    l = sorted(priorities)
    
    for i, j in enumerate(priorities):
        q.append(j)
        idx.append(i)
    answer = 1
    while len(q) > 0:
        x, y = q.popleft(), idx.popleft()
        if x == l[-1]:
            l.pop()
            if y == location:
                return answer
            answer += 1
        else:
            q.append(x)
            idx.append(y)