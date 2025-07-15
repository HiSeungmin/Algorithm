from collections import deque

V = int(input())
tree = [[] for _ in range(V+1)] 

for _ in range(V):
    lst = list(map(int, input().split()))
    lst.pop()
    
    for i in range(1,len(lst)-1,2):
        tree[lst[0]].append([lst[i],lst[i+1]])
    
def bfs(x):
    visited = [-1]*(V+1)
    q = deque()
    q.append(x)
    visited[x] = 0
    dist = [0, 0]

    while q:
        now = q.popleft()
        for a, b in tree[now]:
            if visited[a] == -1:
                visited[a] = visited[now] + b
                q.append(a)

                if visited[a] > dist[1]:
                    dist = [a, visited[a]]
    
    return dist

node = bfs(1)[0]
print(bfs(node)[1])