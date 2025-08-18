import sys
input = sys.stdin.readline

def dfs(n,k):
    global ans
    if n == M:
        s = 0
        for hx, hy in house:
            dis = 1e9
            for i in range(len(chicken)):
                if v[i] == 1:
                    ch = abs(hx-chicken[i][0])+abs(hy-chicken[i][1])
                    dis = min (dis,ch)
            s+=dis
        ans=min(ans,s)
        return

    for i in range(k,len(chicken)):
        if v[i] == 0:
            v[i] = 1
            dfs(n+1,i+1)
            v[i] = 0
        
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
ans = 1e9
house = []
chicken = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            house.append([i,j])
        if arr[i][j] == 2:
            chicken.append([i,j])
v=[0]*len(chicken)
dfs(0,0)
print(ans)