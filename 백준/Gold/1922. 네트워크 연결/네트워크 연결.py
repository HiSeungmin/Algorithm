import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())
M = int(input())

edges = [list(map(int, input().split())) for _ in range(M)]
parent = list(range(N+1))

edges.sort(key = lambda x:x[2])

def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    A = find(a)
    B = find(b)

    if(A<=B):
        parent[B] = A
    else:
        parent[A] = B

answer = 0
for edge in edges:
    x, y, w = edge
    if(find(x)!=find(y)):
        union(x, y)
        answer += w

print(answer)