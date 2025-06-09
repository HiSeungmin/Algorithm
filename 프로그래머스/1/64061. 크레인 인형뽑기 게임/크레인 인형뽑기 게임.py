def solution(board, moves):
    answer = 0
    x, y = len(board), len(board[0])
    st = [[] for _ in range(y)]
    a=0
    for i in range(x-1,-1,-1):
        for j in range(y):
            if board[i][j] > 0: 
                st[j].append(board[i][j])
        a += 1
    
    basket = []
    for k in moves:
        if len(st[k-1])>0:
            doll = st[k-1].pop()
            if len(basket) >0 and basket[-1] == doll:
                basket.pop()
                answer+=2
            else:
                basket.append(doll)

    return answer