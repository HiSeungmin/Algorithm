from collections import deque

com = int(input())
num = int(input())
arr = [[] for _ in range(com+1)]

for i in range(num):
    a,b = map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)

q = deque(arr[1])
visited = [0 for _ in range(com+1)]
visited[1] = 1

while len(q)!=0:
    x = q.popleft()

    if visited[x] == 0:
        visited[x] = 1
        for i in arr[x]:
            q.append(i)

print(visited.count(1)-1)