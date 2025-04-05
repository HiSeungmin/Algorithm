from collections import deque
import copy
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

N = int(input())
arr = []

for _ in range(N):
    arr.append(list(input()))

arr2 = copy.deepcopy(arr)

for i in range(N):
    for j in range(N):
        if arr2[i][j] == 'G':
            arr2[i][j] = 'R'

def bfs(arr, a, b, c):
    q = deque()
    q.append((a, b))
    arr[a][b] = '-'

    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<N and 0<=ny<N and arr[nx][ny] == c :
                arr[nx][ny] = '-'
                q.append((nx,ny))

p1 = 0
p2 = 0

for k in range(N):
    for h in range(N):
        if arr[k][h] != '-':
            bfs(arr, k, h, arr[k][h])
            p1 += 1
        if arr2[k][h] != '-':
            bfs(arr2, k, h, arr2[k][h])
            p2 += 1

print(p1, p2)