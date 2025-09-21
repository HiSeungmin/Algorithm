N = int(input())
d = [0] * (N+1)

for k in range(2, N+1):
    d[k] = d[k-1] +1
    if k%3 == 0:
        d[k] = min(d[k], d[k//3]+1)
    if k%2 == 0:
        d[k] = min(d[k],d[k//2]+1)
    
print(d[N])