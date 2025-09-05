paper = [list(map(int,input().split())) for _ in range(5)]
MC = [ list(map(int,input().split())) for _ in range(5)]

def chk(paper):
    cnt = 0
    x = 0
    y = 0

    for k in range(5): # 세로줄
        if paper[x][y+k] == 0:
            flag = 1
            for j in range(1,5):
                if paper[x+j][y+k] != 0:
                    flag = 0
                    break
            if flag == 1:
                cnt += 1
    
    for k in range(5): # 가로줄
        if paper[x+k][y] == 0:
            flag = 1
            for j in range(1,5):
                if paper[x+k][y+j] != 0:
                    flag = 0
                    break
            if flag == 1:
                cnt += 1

    if paper[0][0] == paper[1][1] == paper[2][2] == paper[3][3] == paper[4][4]:
        cnt += 1
    if paper[0][4] == paper[1][3] == paper[2][2] == paper[3][1] == paper[4][0]:
        cnt += 1
    
    return cnt
               
eMC = sum(MC, [])
ePaper = sum(paper, [])
for k in range(len(eMC)):

    nn = ePaper.index(eMC[k])
    kX = nn//5
    kY = nn%5    

    paper[kX][kY] = 0

    if chk(paper) >= 3:
        print(k+1)
        exit(0)        