N = int(input())
arrN = list(map(int, input().split()))
M = int(input())
arrM = list(map(int, input().split()))

dic = {}

for i in arrN:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

for j in arrM:
    if j in dic:
        print(dic[j], end=" ")
    else:
        print(0, end=" ")