import heapq
from sys import maxsize

N = int(input())
M = int(input())

graph = [[] for _ in range(N + 1)]
visited = [maxsize] * (N + 1)
for _ in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))

start, end = map(int, input().split())


def dijkstra(x):
    pq = []
    heapq.heappush(pq, (0, x))
    visited[x] = 0

    while pq:
        d, x = heapq.heappop(pq)

        if visited[x] < d:
            continue

        for nw, nx in graph[x]:
            nd = d + nw

            if visited[nx] > nd:
                heapq.heappush(pq, (nd, nx))
                visited[nx] = nd


dijkstra(start)
print(visited[end])