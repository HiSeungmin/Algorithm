from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

a, b = map(int, input().split())
arr = []

for _ in range(a):
    arr.append(list(map(int,input())))

q = deque([(0,0)])

while q:
    x, y = q.popleft()

    for k in range(4):
        nx = x+dx[k]
        ny = y+dy[k]

        if 0<=nx<a and 0<=ny<b and arr[nx][ny] == 1:
            q.append((nx, ny))
            arr[nx][ny] = arr[x][y]+1

print(arr[-1][-1])