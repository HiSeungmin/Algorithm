N, K = map(int, input().split())
coin = [int(input()) for _ in range(N)]
coin.sort(reverse=True)
cnt = 0
for i in coin:
    if K==0:
        break
    if K < i:
        continue
    n = (K//i)
    cnt += n
    K -= (n*i)
    
print(cnt)