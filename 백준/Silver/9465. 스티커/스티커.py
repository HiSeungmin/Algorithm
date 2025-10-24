T = int(input())

while T>0:
    T-=1
    n = int(input())
    arr = []

    for _ in range(2):
        arr.append(list(map(int, input().split())))

    if n==1:
        print(max(arr[0][0], arr[1][0]))
    else:
        result = []
        result.append([arr[0][0]])
        result.append([arr[1][0]])

        result[0].append(arr[1][0]+arr[0][1])
        result[1].append(arr[0][0]+arr[1][1])

        for i in range(2, n):
            
            result[0].append(max(max(result[0][i-2],result[1][i-2])+arr[0][i], result[1][i-1]+arr[0][i]))
            result[1].append(max(max(result[0][i-2],result[1][i-2])+arr[1][i], result[0][i-1]+arr[1][i]))

        print(max(result[0][-1], result[1][-1]))