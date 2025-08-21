def dfs(n,s,lst):
     
    if len(lst) == M:
        print(*lst)
        return

    for k in range(s,N+1):
        dfs(n+1,k,lst+[k])

N, M = map(int, input().split())
dfs(0,1, [])