from bisect import bisect_left

N = int(input())
arr = list(map(int, input().split()))
dp = []

for num in arr:
    k = bisect_left(dp, num)

    if len(dp) == k:
        dp.append(num)
    else:
        dp[k] = num

print(len(dp))