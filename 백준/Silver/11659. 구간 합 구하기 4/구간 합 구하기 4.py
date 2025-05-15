import sys
input = sys.stdin.readline
N, M = map(int, input().split(' '))
arr = list(map(int,input().split(' ')))
sum = 0

new_arr = [0] 
for k in range(N):
    sum += arr[k]
    new_arr.append(sum)


for _ in range(M):
    a, b = map(int, input().split(' '))
    print(new_arr[b]-new_arr[a-1])