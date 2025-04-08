N = int(input())

num = N//5
cnt = 5000
sugar = N

while num > -1:
    sugar = N - (5*num)
    t = sugar//3
    if sugar >= 0 and sugar%3 == 0:
        cnt = min(cnt, num+t)
    
    num -= 1

if cnt == 5000:
    print(-1)
else:
    print(cnt)