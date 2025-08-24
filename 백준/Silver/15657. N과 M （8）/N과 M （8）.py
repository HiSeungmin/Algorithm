def dfs(n,s,lst):
    if len(lst)==M:
        print(*lst)
        return
        
    for k in range(s, N):
        dfs(n+1,k,lst+[arr[k]])

N, M = map(int, input().split())
arr = list(map(int,input().split()))
arr.sort()
dfs(0,0,[])