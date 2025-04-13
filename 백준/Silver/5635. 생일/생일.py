n = int(input())
arr = []

for _ in range(n):
    name, dd, mm ,yy = input().split()
    arr.append([int(yy), int(mm), int(dd), name])

arr.sort(reverse=True)

print(arr[0][-1])
print(arr[-1][-1])