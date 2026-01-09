import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

V, E = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(E)]
parent = list(range(V+1))
res = 0

edges.sort(key = lambda x : x[2])

def find(x):
    if x == parent[x]:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x <= y:
        parent[y] = x
    else:
        parent[x] = y

for i in range(E):
    x, y, c = edges[i]
    if find(x) != find(y):
        union(x, y)
        res += c

print(res)