from collections import deque

A, B = map(int, input().split())
q = deque()
q.append([A,1])

cnt = -1
while q:
    x, cnt = q.popleft()

    if x == B:
        print(cnt)
        exit(0)
    for nx in (x*2, x*10+1):
        if nx <= B:
            q.append([nx, cnt+1])

print(-1)