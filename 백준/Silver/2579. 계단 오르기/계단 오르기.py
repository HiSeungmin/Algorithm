N = int(input())
stairs = [0]*301
for i in range(1,N+1):
    stairs[i] = int(input())

dp = [0]*301
dp[1] = stairs[1]
dp[2] = stairs[1]+stairs[2]
dp[3] = max(stairs[1]+stairs[3], stairs[2]+stairs[3])

for k in range(4,N+1):
    dp[k] = max(dp[k-3]+stairs[k-1]+stairs[k], dp[k-2]+stairs[k])

print(dp[N])