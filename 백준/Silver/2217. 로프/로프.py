N = int(input())
ropes = [int(input()) for _ in range(N)]
ropes.sort()

max = 0
for idx in range(N):
    if max <= ropes[idx]*(N-idx):
        max = ropes[idx]*(N-idx)

print(max)