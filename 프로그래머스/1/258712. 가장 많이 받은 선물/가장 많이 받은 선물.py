def solution(friends, gifts):
    n = len(friends)
    graph = [[0]*n for _ in range(n)]

    arr = []
    next = [0]*n

    for str in gifts:
        giv, rec = str.split(' ')
        graph[friends.index(giv)][friends.index(rec)] += 1
             
    for i in range(n):
        
        giv = sum(graph[i])
        rec = 0

        for j in range(n):
            rec += graph[j][i]
        
        arr.append(giv-rec)
    
    for i in range(n):
        for j in range(i+1, n):
            a = graph[i][j]
            b = graph[j][i]
            if a == b or (a==0 and b==0):
                if arr[i] > arr[j]:
                    next[i] += 1
                elif arr[i] < arr[j]:
                    next[j] += 1
            elif a > b:
                next[i] += 1
            else:
                next[j] += 1

    return max(next)