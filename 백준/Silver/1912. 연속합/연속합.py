n = int(input())
arr = list(map(int, input().split()))

ans = [0]*n
ans[0] = arr[0]

for i in range(1, n):
    ans[i] = max(arr[i], arr[i]+ans[i-1])

print(max(ans))