from collections import deque
T = int(input())

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def bfs(feild, i, j):
    q = deque()
    q.append([i,j])
    feild[i][j] = 0

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0<=nx<N and 0<=ny<M and feild[nx][ny] == 1:
                feild[nx][ny] = 0
                q.append([nx,ny])

for _ in range(T):
    M, N, K = map(int, input().split())
    feild = [[0]*(M+1) for _ in range(N+1)]

    for _ in range(K):
        a, b = map(int, input().split())
        feild[b][a] = 1

    cnt = 0

    for i in range(N):
        for j in range(M):
            if feild[i][j] == 1:
                cnt += 1
                bfs(feild,i,j)

    print(cnt)
