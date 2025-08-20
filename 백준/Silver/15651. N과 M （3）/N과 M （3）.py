def dfs(n, lst):
    if n == M:
        print(*lst)
        return

    for k in range(1,N+1):
        dfs(n+1,lst+[k])

N, M = map(int, input().split())
dfs(0,[])