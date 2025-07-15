import sys
t = int(input()) 

for _ in range(t):
    n = int(input())
    phone = [input() for _ in range(n)] 
    phone.sort() # 정렬

    for i in range(n-1):
        length = len(phone[i])
        if phone[i] == phone[i+1][:length]:
            print('NO')
            break
    else:
        print('YES')