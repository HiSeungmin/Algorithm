from collections import deque

N = int(input())
lst = [[] for _ in range(N+1)]
for _ in range(N-1):
    a, b = map(int, input().split())
    lst[a].append(b)
    lst[b].append(a)

def find_parent(n):
    visited = [0] * (N+1)
    parents = [0] * (N+1)

    q = deque()
    q.append(n)

    while q:
        x = q.popleft()
        for i in lst[x]:
            if visited[i] == 0:
                visited[i] = 1
                parents[i] = x
                q.append(i)

    for k in range(2, len(parents)):
        print(parents[k])

find_parent(1)