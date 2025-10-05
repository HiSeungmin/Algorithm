def solution(money):
    dp = [0] * len(money)
    dp[0] = money[0]

    for i in range(1, len(money)-1):
        dp[i] = max(dp[i-1], money[i] + dp[i-2])

    dp2 = [0] * len(money)
    dp2[0] = 0

    for i in range(1, len(money)):
        dp2[i] = max(dp2[i-1], money[i] + dp2[i-2])

    return max(max(dp), max(dp2))