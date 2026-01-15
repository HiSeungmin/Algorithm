import sys
input = sys.stdin.readline

def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


V, E = map(int, input().split())

edges = [list(map(int, input().split())) for _ in range(E)]
parent = list(range(V+1))

edges.sort(key=lambda x: x[2]) 
ans = 0 
end = 0  
for edge in edges:
    x, y, w = edge
    if find(x) != find(y):
        union(x, y)
        ans += w
        end = w

print(ans - end)