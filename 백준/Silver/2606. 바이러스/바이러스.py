from collections import deque
com = int(input())
pair_num = int(input())

arr = [[]*1 for _ in range(com+1)]
for _ in range(pair_num):
    a, b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

visited = [0] * (com+1)

q = deque()
q.append(1)

cnt = 0

while q:
    x = q.popleft()    
    if visited[x] != 1:
        for k in arr[x]:
            q.append(k)
        visited[x] = 1
        cnt += 1

print(cnt-1)