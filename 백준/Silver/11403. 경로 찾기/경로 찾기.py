N = int(input())
arr = []

for _ in range(N):
    arr.append(list(map(int,input().split())))
    
for k in range(0, N):         
    for i in range(0, N):     
        for j in range(0, N): 
            if arr[i][k]==1 and arr[k][j]==1:
                arr[i][j] = 1

for li in arr:
    for el in li:
        print(el, end =" ")
    print()