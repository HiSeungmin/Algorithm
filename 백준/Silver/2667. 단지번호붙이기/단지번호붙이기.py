from collections import deque

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs(x, y):
    cnt = 1
    q = deque()
    q.append((x, y))
    arr[x][y] = 0

    while q:
        x, y = q.popleft()
        
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]

            if 0<=nx<N and 0<=ny<N and arr[nx][ny]==1:
                arr[nx][ny] = 0
                cnt+=1
                q.append((nx,ny))

    return cnt

N = int(input())
arr = []
count_home = []

for _ in range(N):
    arr.append(list(map(int,input())))

for x in range(N):
    for y in range(N):
        if arr[x][y] == 1:
            count_home.append(bfs(x,y))

count_home.sort()
print(len(count_home))
for i in count_home:
    print(i)