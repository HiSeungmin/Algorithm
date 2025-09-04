def solution(brown, yellow):
    answer = []
    all = brown + yellow

    for k in range(1,all//2+1):
        if all%k == 0:
            m = all//k
            
            if (k-2)*(m-2) != yellow or (all - (k-2)*(m-2)) != brown:
                continue
            
            answer.append(k)
            answer.append(m)
            break

    answer.sort(reverse=True)
    return answer