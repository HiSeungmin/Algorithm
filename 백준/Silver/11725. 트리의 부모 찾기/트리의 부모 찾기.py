import sys
sys.setrecursionlimit(10**5)
N = int(sys.stdin.readline())
tree = [[] for _ in range(N+1)]

for _ in range(N-1):
    a, b = map(int, input().split())
    tree[a].append(b)
    tree[b].append(a)

checked = [0] * (N+1)
def dfs(x):
    for i in tree[x]:
        if checked[i] == 0:
            checked[i] = x
            dfs(i)

dfs(1)

for k in range(2, N+1):
    print(checked[k])