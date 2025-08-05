import sys

N, M = map(int, sys.stdin.readline().split())
arr = []

for _ in range(N):
    arr.append(int(input()))

start = max(arr)
end = max(arr)*N
answer = 0

while start<=end:
    mid = (start+end)//2 
    cnt = 0
    balance = 0

    for k in arr:

        if balance-k<0:
            cnt+=1
            balance = mid
        balance -= k
    
    if cnt > M:
        start = mid + 1
    else:
        answer = mid
        end = mid - 1

print(answer)