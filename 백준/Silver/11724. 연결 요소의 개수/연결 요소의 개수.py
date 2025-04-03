from collections import deque

N, M = map(int, input().split())

arr = [[] for _ in range(N+1)]
visited = [0]*(N+1)
for _ in range(M):
    u, v = map(int,input().split())
    arr[u].append(v)
    arr[v].append(u)
q = deque()
def dfs():
    while q:
        K = q.popleft()
        visited[K] = 1
        for k in arr[K]:
            if visited[k] == 0:
                q.append((k))
                visited[k] = 1
cnt = 0
for i in range(1, N+1):
    if visited[i] == 0:
        q.append(i)
        dfs()
        cnt += 1

print(cnt)
