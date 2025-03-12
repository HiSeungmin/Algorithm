N = int(input())
arr = []

for _ in range(N):
    arr_input = list(map(int, input().split()))
    arr.append([arr_input[1], arr_input[0]])

arr.sort()

for i in range(len(arr)):
    print(arr[i][1], arr[i][0])