def dfs(n, k, lst):
    if n == M:
        answer.append(lst)
        return
    
    for i in range(k, len(arr)):
        dfs(n+1, i+1, lst+[arr[i]])

N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
answer = []
dfs(0, 0, [])
for k in answer:
    print(*k)