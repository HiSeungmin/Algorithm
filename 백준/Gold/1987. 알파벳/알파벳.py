import sys
from collections import deque
input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def back(x, y, cnt):
    global max_cnt
    max_cnt = max(max_cnt, cnt)
    
    for k in range(4):
        nx = x+dx[k]
        ny = y+dy[k]
        
        if 0<=nx<R and 0<=ny<C:

            if v[ord(arr[nx][ny])-65] == 0:
                v[ord(arr[nx][ny])-65] = 1
                back(nx, ny, cnt+1)
                v[ord(arr[nx][ny])-65] = 0


R, C = map(int,input().split())
arr = [list(input()) for _ in range(R)]
v = [0]*27
max_cnt = 0
v[ord(arr[0][0])-65] = 1
back(0, 0, 1)
print(max_cnt)