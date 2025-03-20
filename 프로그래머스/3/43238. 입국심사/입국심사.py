def getImmigration(n ,times, time):
    res = 0
    for i in times:
        res += (time // i)
    return res

def solution(n, times):
    left = min(times) 
    right = max(times) * n 
    answer = right  

    while left <= right:
        mid = (left + right) // 2
        person = getImmigration(n, times, mid)

        if person >= n: 
            answer = mid
            right = mid - 1
        else: 
            left = mid + 1

    return answer