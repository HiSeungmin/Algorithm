N = int(input())
meeting = []

for _ in range(N):
    meeting.append(list(map(int, input().split())))

meeting.sort()
meeting.sort(key = lambda a:a[1])
small = meeting[0][1]
cnt = 1

for i in range(1,N):
    if small <= meeting[i][0]:
        small = meeting[i][1]
        cnt += 1

print(cnt)