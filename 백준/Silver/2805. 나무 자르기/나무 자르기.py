import sys
N, M = map(int,sys.stdin.readline().split())
arr = []
arr = list(map(int, sys.stdin.readline().split()))

start = 0
end = max(arr)

while start <= end:
    mid = (start + end)//2
    cnt = 0
    for k in arr:
        if k >= mid:
            cnt += k - mid
    if cnt >= M:
        start = mid + 1
    else:
        end = mid - 1


print(end)