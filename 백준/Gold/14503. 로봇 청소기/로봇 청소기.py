dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

N, M = map(int,input().split())
r, c, d = map(int,input().split())
arr = [(list(map(int, input().split()))) for _ in range(N)]

visited = [[0]*M for _ in range(N)]
visited[r][c] = 1

cnt = 1

while True:
    flag = False

    for _ in range(4):
        d = (d+3) % 4
        nr = r + dr[d]
        nc = c + dc[d]

        if 0 <= nr <= N and 0 <= nc < M and arr[nr][nc] == 0:
            if visited[nr][nc] == 0:
                visited[nr][nc] = 1
                cnt +=1
                r = nr
                c = nc
                flag = True
                break
    
    if flag == False:
        if arr[r-dr[d]][c-dc[d]] == 1:
            print(cnt)
            break
        else:
            r, c = r-dr[d], c-dc[d]    