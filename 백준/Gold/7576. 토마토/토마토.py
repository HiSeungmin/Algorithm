from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

M, N = map(int, input().split())
field = []
q = deque()
for i in range(N):
    field.append(list(map(int, input().split())))
    for j in range(M):
        if field[i][j] == 1:
            q.append([i,j])

def bfs():
    while q:
        x, y = q.popleft()
        for i in range(4): 
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<N and 0<=ny<M and field[nx][ny] == 0:
                field[nx][ny] = field[x][y] + 1
                q.append([nx, ny])

bfs()
date = 0
for k in field:
    for m in k:
        if m == 0:
            print(-1)
            exit(0)
    date = max(date, max(k))

print(date-1)
