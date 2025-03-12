N = int(input())
arr = []
for _ in range(N):
    arr_input = list(map(int, input().split()))
    arr.append(arr_input)
    
arr.sort()

for i in range(N):
    print(arr[i][0], arr[i][1])