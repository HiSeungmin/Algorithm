import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

sum = 0
num = [0] * M

for i in range(N):
  sum += arr[i]
  num[sum % M] += 1

result = num[0]

for i in num:
  result += i*(i-1)//2

print(result) 