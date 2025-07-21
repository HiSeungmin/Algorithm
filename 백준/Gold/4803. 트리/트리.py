import sys
sys.setrecursionlimit(100000)

def dfs(curr, prev, graph, visited):
    visited[curr] = True
    for next in graph[curr]:
        if not visited[next]:
            if not dfs(next, curr, graph, visited):
                return False
        elif next != prev:
            return False
    return True

case = 1
while True:
    a, b = map(int, input().split())
    cnt = 0

    if a == b == 0:
        break

    graph = [[] for _ in range(a+1)]
    visited = [0] * (a+1)

    for _ in range(b):
        x, y = map(int, input().split())
        graph[x].append(y)
        graph[y].append(x)

    for k in range(1, a+1):
        if visited[k] == 0:
            if dfs(k, -1, graph, visited):
                cnt+=1
    
    if cnt == 0:
        print(f"Case {case}: No trees.")
    elif cnt == 1:
        print(f"Case {case}: There is one tree.")
    else:
        print(f"Case {case}: A forest of {cnt} trees.")

    case += 1