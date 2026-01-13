import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

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

n = int(input())
m = int(input())
arr = []
parent = [i for i in range(n+1)]
res = 0
for i in range(m):
    a, b, c = map(int, input().split())
    arr.append((c, a, b))

arr.sort(key=lambda x:x[0])
for dis, a, b in arr:
    if find(a) != find(b):
        union(a, b)
        res += dis

print(res)