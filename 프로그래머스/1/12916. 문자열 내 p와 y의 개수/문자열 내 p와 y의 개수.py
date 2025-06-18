def solution(s):
    pCnt = 0
    yCnt = 0
    for ch in s:
        if ch == 'P' or ch == 'p':
            pCnt += 1
        elif ch == 'Y' or ch =='y':
            yCnt += 1
    if pCnt == yCnt:
        return True
    else:
        return False