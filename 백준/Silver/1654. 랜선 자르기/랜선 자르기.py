K, N = map(int, input().split(' ')) 
arr = []
for _ in range(K):
    arr.append(int(input()))

arr.sort()

def cables_cnt(m):
    cables = 0
    for i in range(K):
        cables += (arr[i]//m)
    return cables

left, right, mid = 1, arr[-1], 0
result = 0
while left <= right:
    mid = (left + right)//2
    cnt = cables_cnt(mid)
    if cnt < N:
        right = mid - 1
    elif cnt >= N:
        left = mid + 1
        result = mid

print(result)