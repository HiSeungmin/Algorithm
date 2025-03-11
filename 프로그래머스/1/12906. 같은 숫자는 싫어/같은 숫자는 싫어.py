def solution(arr):
    result = []
    
    for i in arr:
        if len(result) == 0 or result[-1] != i:
            result.append(i)
    
    return result