def dfs(n, lst):
    if n==M:
        print(*lst)
        return
    
    for k in range(N):
        dfs(n+1,lst+[arr[k]])
        

N,M = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
dfs(0,[])