from collections import deque

n = int(input())
a, b = map(int, input().split())
m = int(input())

arr = [[]*1 for _ in range(n+1)]

for _ in range(m):
    x, y = map(int, input().split())
    arr[x].append(y)
    arr[y].append(x)

def bfs():
    q = deque()
    q.append(a)
    while q:
        x = q.popleft()
        for nx in arr[x]:
            if 0<=nx<=10**5 and not dist[nx]:
                dist[nx] = dist[x] + 1
                q.append(nx)

dist = [0]*(n+1)
bfs()
if dist[a]==0 or dist[b]==0:
    print(-1)
else:
    print(dist[b])