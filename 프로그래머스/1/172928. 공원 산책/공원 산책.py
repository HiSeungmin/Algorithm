def dfs(park, cur, op, n, h, w):
    ans = [cur[0], cur[1]]
    for _ in range(n):
        n_x = ans[0] + op[0]
        n_y = ans[1] + op[1]

        if 0 > n_x or n_x>=h or 0>n_y or n_y>=w:
            return cur
        if park[n_x][n_y] == "X":
            return cur
        
        ans = [n_x, n_y]
    return ans

def solution(park, routes):
    current = [0, 0]
    h = len(park)
    w = len(park[0])
    for i in range(h):
        for j in range(w):
            if park[i][j] == "S":
                current = [i, j]
                break

    for k in routes:
        op, n = k.split()

        if op == "E":
            current = dfs(park, current, [0, 1], int(n), h, w)
        elif op == "W":
            current = dfs(park, current, [0, -1], int(n), h, w)
        elif op == "S":
            current = dfs(park, current, [1, 0], int(n), h, w)
        elif op =="N":
            current = dfs(park, current, [-1, 0], int(n), h, w)
    
    return current