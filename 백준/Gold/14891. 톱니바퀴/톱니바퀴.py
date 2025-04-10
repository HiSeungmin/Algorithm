from collections import deque
wheel = []
for _ in range(4):
    wheel.append(deque(list(input())))
K = int(input())

def left(num, direction):
    if num < 0:
        return
    if wheel[num][2] != wheel[num+1][6]:
        left(num-1, -direction)
        wheel[num].rotate(direction)

def right(num, direction):
    if num > 3:
        return
    if wheel[num][6] != wheel[num-1][2]:
        right(num+1, -direction)
        wheel[num].rotate(direction)

for i in range(K):
    num, direction = map(int, input().split())
    num -= 1
    left(num-1, -direction)
    right(num+1, -direction)
    wheel[num].rotate(direction)

cnt = 0

if wheel[0][0] == '1':
    cnt += 1
if wheel[1][0] == '1':
    cnt += 2
if wheel[2][0] == '1':
    cnt += 4
if wheel[3][0] == '1':
    cnt += 8

print(cnt)    