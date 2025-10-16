def solution(d, budget):
    d.sort()
    cnt = 0

    for amt in d:
        if(budget<amt):
            break
        budget -= amt
        cnt += 1
    
    return cnt if budget >= 0 else cnt-1 