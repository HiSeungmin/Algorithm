from collections import deque

n, m = map(int, input().split())
graph = []

visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]
visited[0][0][0] = 1 # visited[x][y][0] : 안 부신 경우, [1] : 부신 경우

for i in range(n):
    graph.append(list(map(int, input())))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(x, y, z):
    q = deque()
    q.append((x,y,z))

    while q:
        a, b, c = q.popleft()

        if a == n-1 and b == m-1:
            return visited[a][b][c]

        for k in range(4):
            nx = a+dx[k]
            ny = b+dy[k]

            if 0>nx or nx >= n or 0>ny or ny>=m:
                continue

            if graph[nx][ny]==1 and c == 0:
                visited[nx][ny][1] = visited[a][b][c] + 1
                q.append((nx,ny,1))
            elif graph[nx][ny]==0 and visited[nx][ny][c] == 0:
                visited[nx][ny][c] = visited[a][b][c] + 1
                q.append((nx,ny,c))

    return -1

print(bfs(0, 0, 0))