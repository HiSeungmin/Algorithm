from bisect import bisect_left
n = int(input())
A = list(map(int, input().split()))
dp = []


for num in A:
    k = bisect_left(dp,num)
    if len(dp) == k:
        dp += [num]
    else:
        dp[k] = num
print(len(dp))