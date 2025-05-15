import sys
N, M = map(int, sys.stdin.readline().split(' '))
arr = list(map(int,sys.stdin.readline().split(' ')))
sum = 0

new_arr = [0] 
for k in range(N):
    sum += arr[k]
    new_arr.append(sum)


for _ in range(M):
    a, b = map(int, sys.stdin.readline().split(' '))
    print(new_arr[b]-new_arr[a-1])