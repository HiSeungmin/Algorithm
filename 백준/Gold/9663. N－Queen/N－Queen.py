def dfs(n):
    global ans
    if n==N:
        ans+=1
        return
    for k in range(N):
        if v1[k]==v2[n+k]==v3[n-k]==0:
            v1[k]=v2[n+k]=v3[n-k]=1
            dfs(n+1)
            v1[k]=v2[n+k]=v3[n-k]=0

N = int(input())
ans = 0
v1 = [0]*N
v2 = [0]*(2*N)
v3 = [0]*(2*N)
dfs(0)
print(ans)