import sys
input = sys.stdin.readline

n = int(input())
switches = list(map(int, input().split()))
lambs = list(map(int, input().split()))

pos = {num: i for i, num in enumerate(lambs)}

dp = [1]*n

for i in range(1, n):
    for j in range(0, i):
        if pos[switches[i]] > pos[switches[j]]:
            dp[i] = max(dp[i], dp[j]+1)


print(max(dp))
last_idx = max(dp)
output = []
for k in range(n-1, -1, -1):
    if dp[k] == last_idx:
        output.append(switches[k])
        last_idx -= 1

output.sort()
print(*output)