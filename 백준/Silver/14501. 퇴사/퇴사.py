N = int(input())
T = [0]*(N+2)
P = [0]*(N+2)
for i in range(1,N+1):
    a, b = map(int,input().split())
    T[i] = a
    P[i] = b

dp = [0]*(N+2)
for i in range(1,N+1):
    for j in range(i+T[i], N+2):
        if dp[j] < dp[i]+P[i]:
            dp[j] = dp[i]+P[i]

print(dp[-1])