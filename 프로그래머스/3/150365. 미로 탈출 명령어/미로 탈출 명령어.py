import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)

def solution(n, m, x, y, r, c, k):
    
    directions = [(1, 0, 'd'), (0, -1, 'l'), (0, 1, 'r'), (-1, 0, 'u')]
    
    result = []

    dist = abs(x - r) + abs(y - c)

    if dist > k or (dist % 2) != (k % 2):
        return "impossible"
    
    def dp(cur_x, cur_y, path, remaining):
        
        if result:
            return
        
        if remaining == 0:
            if cur_x == r and cur_y == c:
                result.append(path)
            return
        
        dist = abs(cur_x - r) + abs(cur_y - c)
        
        if dist > remaining:
            return
        
        if (dist % 2) != (remaining % 2):
            return
        
        for dx, dy, direction in directions:
            nx, ny = cur_x + dx, cur_y + dy
            
            if 1 <= nx <= n and 1 <= ny <= m:
                dp(nx, ny, path + direction, remaining - 1)
    
    dp(x, y, '', k)
    
    return "impossible" if len(result) == 0 else result[0]