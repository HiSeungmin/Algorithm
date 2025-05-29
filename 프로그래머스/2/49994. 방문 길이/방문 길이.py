def solution(dirs):
    answer = 0

    dx = [0, 0, 1, -1]
    dy = [-1, 1, 0, 0]
    visited = [[[[False for _ in range(11)] for _ in range(11)] for _ in range(11)] for _ in range(11)]

    nx = 5
    ny = 5
    index = 0

    for i in dirs:
        x = nx
        y = ny

        if i == 'U': index = 0
        elif i == 'D': index = 1
        elif i == 'R': index = 2
        elif i == 'L': index = 3

        nx += dx[index]
        ny += dy[index]

        if nx<0 or nx>10 or ny<0 or ny>10:
            nx -= dx[index]
            ny -= dy[index]
            continue

        if visited[x][y][nx][ny] == False or visited[nx][ny][x][y] == False:
            visited[x][y][nx][ny] = True
            visited[nx][ny][x][y] = True
            answer += 1

    return answer