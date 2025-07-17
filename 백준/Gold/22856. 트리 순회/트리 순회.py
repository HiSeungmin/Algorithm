import sys
sys.setrecursionlimit(10**6) 

def inorder(n):
    global end_node
    if n != -1:
        inorder(arr[n][0])
        end_node = n
        inorder(arr[n][1])

def counted(n):
    global cnt, ans

    if arr[n][0] != -1:
        cnt += 1
        counted(arr[n][0])
        cnt += 1

    if n == end_node:
        ans = cnt
        return

    if arr[n][1] != -1:
        cnt += 1
        counted(arr[n][1])
        cnt += 1


N = int(input())
arr = [[] for _ in range(N+1)]
cnt = 0
ans = 0
for _ in range(N):
    a, b, c = map(int, input().split())
    arr[a] = [b,c]

inorder(1)
counted(1)
print(ans)