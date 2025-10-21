sensor = int(input())
country = int(input())
arr = list(map(int, input().split(' ')))
arr2=[]
arr.sort()

arr2.append(0)
for i in range(1, len(arr)):
    a = abs(arr[i]-arr[i-1])
    arr2.append(a)

arr2.sort()
p = country-1

if p>0 and len(arr2)>=p:
    for _ in range(p):
        arr2.pop()

result = sum(arr2)
print(result)