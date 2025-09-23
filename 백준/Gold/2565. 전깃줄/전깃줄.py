n = int(input())
conn = []
dp = [1]*n

for _ in range(n):
    a, b = map(int, input().split())
    conn.append([a,b])

conn.sort()

for i in range(1, n):
    for j in range(0, i):
        if conn[j][1] < conn[i][1]:
            dp[i] = max(dp[i], dp[j]+1)

print(n-max(dp))