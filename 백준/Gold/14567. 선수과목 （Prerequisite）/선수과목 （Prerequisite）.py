import sys
from collections import deque

def topology_sort():
    result = [1]*(v+1)
    q = deque()

    for i in range(1, v+1):
        if indegree[i] == 0:
            q.append(i)
            
    while q:
        now = q.popleft()
        for i in graph[now]:
            indegree[i] -= 1
            if indegree[i] == 0:
                result[i] = result[now] + 1
                q.append(i)

    print(*result[1:])

v, e = map(int, sys.stdin.readline().split())

indegree = [0]*(v+1)
graph =[[] for i in range(v+1)]
for _ in range(e):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    indegree[b] += 1

topology_sort()