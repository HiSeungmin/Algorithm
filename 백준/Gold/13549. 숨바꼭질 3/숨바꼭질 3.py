from collections import deque
def bfs():
    q = deque()
    q.append(n)
    while q:
        x = q.popleft()
        if x == k:
            print(dist[x])
            break
        n_x = x*2
        if  0<=n_x<=10**5 and not dist[n_x]:
            dist[n_x] = dist[x]
            q.append(n_x)
        for nx in (x-1, x+1):
            if nx!=n_x and 0<=nx<=10**5 and not dist[nx]:
                dist[nx] = dist[x] + 1
                q.append(nx)
        
dist = [0]*(10**5 + 1)
n, k = map(int, input().split())
bfs()