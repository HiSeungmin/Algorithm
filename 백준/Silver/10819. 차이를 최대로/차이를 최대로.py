def mini(lst):
    minSum = 0
    for i in range(len(lst)-1):
        minSum +=abs(lst[i]-lst[i+1])
    return minSum

def dfs(n, lst):
    global ans
    if n == N:
        ans = max(ans,mini(lst))
        return
    
    for k in range(N):
        if v[k] == 0:
            v[k] = 1
            dfs(n+1, lst+[arr[k]])
            v[k] = 0

N = int(input())
arr = list(map(int, input().split()))
v= [0]*N
ans = 0
dfs(0, [])
print(ans)