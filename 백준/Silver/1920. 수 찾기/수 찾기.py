N = int(input())
arrN = list(map(int, input().split()))
M = int(input())
arrM = list(map(int, input().split()))

arrN.sort()

for i in arrM:
    start = 0
    end = N-1
    mid = (start+end)//2

    result = False
    while start <= end:
        mid = (start+end)//2
        if arrN[mid] == i:
            result = True
            print(1)
            break
        elif arrN[mid] < i:
            start = mid+1
        elif arrN[mid] > i:
            end = mid-1
    if result == False:
        print(0)