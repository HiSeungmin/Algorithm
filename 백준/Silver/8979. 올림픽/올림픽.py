N, K = map(int, input().split())
arr = []
for _ in range(N):
    a, b, c, d = map(int,input().split())
    arr.append([b,c,d])
    if a==K:
        ret = str(b)+str(c)+str(d)
arr.sort()
arr.reverse()

rank = 0
for a,b,c in arr:
    rank += 1
    if str(a)+str(b)+str(c)==ret:
        print(rank)
        break