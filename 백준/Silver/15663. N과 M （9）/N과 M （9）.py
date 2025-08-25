def dfs(n, lst):

    if n==M:
        print(*lst)
        return
    
    prev = 0
    for k in range(N):
        if v[k] == 0 and prev != arr[k]:
            prev = arr[k]
            v[k] = 1
            dfs(n+1,lst+[arr[k]])
            v[k] = 0
    

N, M = map(int,input().split())
arr = list(map(int, input().split()))
arr.sort()
v = [0]*N
dfs(0,[])