import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**9)


def Find(x):
    if disjoint[x]!=x:
        disjoint[x]=Find(disjoint[x])
    return disjoint[x]

def Union(a,b):

    a=Find(a)
    b=Find(b)

    if a==b:
        return False

    else:
        if a>b:
            disjoint[a]=b
        else:
            disjoint[b]=a
        return True

N,M=map(int,input().split())

disjoint=[0]*(N+1) ; total=0
for i in range(1,N+1):
    disjoint[i]=i

for i in range(M):
    a,b=map(int,input().split())

    if not Union(a,b):
        total+=1

for i in range(1,N+1):
    if Find(i-1)!=Find(i):
        Union(i-1,i)
        total+=1

print(total-1)