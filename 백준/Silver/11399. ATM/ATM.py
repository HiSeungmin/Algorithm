N = int(input())
arr = list(map(int,input().split()))
arr.sort()
arr2 = [0]*N
arr2[0] = arr[0]
for i in range(1,len(arr)):
    arr2[i] = arr2[i-1]+arr[i]

print(sum(arr2))