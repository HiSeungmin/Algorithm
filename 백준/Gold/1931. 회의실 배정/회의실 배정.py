n = int(input())
t = []
for i in range(n):
    t.append(tuple(map(int, input().split())))

t.sort()
t.sort(key = lambda a:a[1])
p = 1

small = t[0][1]
cnt = 1
for r in range(1, len(t)):
    if small <= t[r][0]:
        small = t[r][1]
        cnt += 1

print(cnt)