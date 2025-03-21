from collections import deque
import sys

input = sys.stdin.readline

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs():
    tmp = [row[:] for row in arr]
    q = deque()
    for i in range(N):
        for j in range(M):
            if tmp[i][j] == 2:
                q.append((i, j))

    while q:
        x, y = q.popleft()

        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]

            if 0<=nx<N and 0<=ny<M and tmp[nx][ny]==0:
                tmp[nx][ny] = 2
                q.append((nx,ny))

    global count
    local_count = 0
    for k in range(N):
        local_count += tmp[k].count(0)
    
    count = max(count, local_count)

def wall(cnt):
    if cnt == 3:
        bfs()
        return
    
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 0:
                arr[i][j] = 1
                wall(cnt+1)
                arr[i][j] = 0


N, M = map(int,input().split())
arr = []

for _ in range(N):
    arr.append(list(map(int,input().split())))

count = 0
wall(0)
print(count)