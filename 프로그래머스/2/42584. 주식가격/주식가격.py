def solution(prices):
    answer = []
    for i, j in enumerate(prices):
        cnt = 0
        for k in range(i+1,len(prices)):
            if prices[k] >=j:
                cnt += 1
            elif prices[k] < j:
                cnt+=1
                break
        answer.append(cnt)
    return answer