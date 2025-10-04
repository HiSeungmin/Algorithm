def solution(triangle):

    n = len(triangle)
    sum = [[0]*(i+1) for i in range(n)]
    sum[0][0] = triangle[0][0]

    for i in range(1, n):
        for j in range(i+1):
            if j == 0:
                sum[i][j] = sum[i-1][j]+triangle[i][j]
            elif j == i:
                sum[i][j] = sum[i-1][j-1]+triangle[i][j]
            else:
                sum[i][j] = max(sum[i-1][j-1], sum[i-1][j]) + triangle[i][j]

    return max(sum[n-1])