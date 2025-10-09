N = int(input())

cnt = 0
i = 0
a = 10
while 1:
    a = N-((N//5)*5)+(5*i)
    
    if a%3 == 0:
        cnt+=(N//5)-i
        print(cnt+(a//3))
        exit(0)
    i+=1
    if (5*i)>N:
        break

if(N%3==0): print(N//3)
else: print(-1)