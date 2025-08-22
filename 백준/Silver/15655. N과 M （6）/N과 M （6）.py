def dfs(n, lst):
    if n == N:
        if len(lst) == M:
            print(*lst)
        return
    
    dfs(n+1,lst+[arr[n]])
    dfs(n+1,lst)

N, M = map(int, input().split())
arr = list(map(int,input().split()))
arr.sort()
v = [0]*N
dfs(0,[])