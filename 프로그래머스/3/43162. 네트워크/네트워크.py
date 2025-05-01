from collections import deque

def solution(n, computers):
    cnt = 0
    visited = [0]*n
    arr = [[] for _ in range(n)]

    for i in range(len(computers)):
        for j in range(len(computers[i])):
            if i==j:
                continue
            if computers[i][j] == 1:
                arr[i].append(j)


    def dfs(a):
        q=deque()
        q.append(a)

        while q:
            x = q.popleft()
            visited[x] = 1

            for i in arr[x]:
                if visited[i] == 0:
                    q.append(i)

    for i in range(len(visited)):
        if visited[i] == 1:
            continue
        dfs(i)
        cnt += 1

    return cnt