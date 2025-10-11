N, M = map(int,input().split())
board=[]
cnt=[]
for i in range(N):
    board.append(input())
    
for a in range(N-7):
    for b in range(M-7): 
        wIdx = 0 
        bIdx = 0 
        for i in range(a, a+8):
            for j in range(b, b+8):
                if (i+j)%2 == 0:
                    if board[i][j]!='W':
                        wIdx+=1
                    else:
                        bIdx+=1
                else:
                    if board[i][j]!='W':
                        bIdx+=1
                    else:
                        wIdx+=1
                        
        cnt.append(wIdx) 
        cnt.append(bIdx) 
print(min(cnt))