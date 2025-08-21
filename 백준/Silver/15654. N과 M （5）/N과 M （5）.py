def dfs(n, lst):
    if n==M:
        print(*lst)
        return
    
    for k in range(N):
        if v[k] == 0:
            v[k] = 1
            dfs(n+1,lst+[arr[k]])
            v[k] = 0

N,M = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
v = [0]*N
dfs(0,[])