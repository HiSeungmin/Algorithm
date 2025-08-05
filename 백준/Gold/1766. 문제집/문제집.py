import sys, heapq
from collections import deque

def topology_sort():
    result = []
    q =[]

    for i in range(v+1):
        if indegree[i] == 0:
            heapq.heappush(q, i)
    
    while q:
        x = heapq.heappop(q)
        result.append(x)

        for k in graph[x]:
            indegree[k] -= 1
            if indegree[k] == 0:
                heapq.heappush(q, k)
    
    print(*result[1:])


v, e = map(int, sys.stdin.readline().split())

indegree = [0]*(v+1)
graph = [[] for _ in range(v+1)]

for _ in range(e):
    a, b = map(int, sys.stdin.readline().split())
    indegree[b] += 1
    graph[a].append(b)
    graph[a].sort()

topology_sort()