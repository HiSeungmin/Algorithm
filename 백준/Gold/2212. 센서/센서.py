N = int(input())
K = int(input())
arr = list(map(int, input().split()))
arr.sort()
d = []
for i in range(N-1):
    d.append(arr[i+1]-arr[i])

d.sort()
print(sum(d[:N-K]))