import sys
input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)

    if a<b:
        parent[b] = a
    else:
        parent[a] = b

N, M = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(M)]
parent = list(range(N+1))

edges.sort(key = lambda x : x[2])

sum = 0
ans = 0
cnt = 0
for edge in edges:
    x, y, z = edge
    sum += z
    if find(x) != find(y):
        union(x, y) 
        ans += z
        cnt += 1

if cnt != N-1:
    print(-1)
else:
    print(sum - ans)