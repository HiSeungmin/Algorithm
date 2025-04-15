def solution(n, lost, reserve):
    
    arr = [1]*(n+1)
    
    lost.sort()

    for i in range(1, n+1):
        if i in lost and i in reserve:
            arr[i] = 1
        elif i in lost:
            arr[i] = 0
        elif i in reserve:
            arr[i] = 2
    
    for k in lost:
        if k > 1 and arr[k-1] == 2:
            arr[k-1] = 1
            arr[k] = 1
        elif k < n and arr[k+1] == 2:
            arr[k+1] = 1
            arr[k] = 1
    lo = arr.count(0)

    return n-lo