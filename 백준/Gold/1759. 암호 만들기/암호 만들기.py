def dfs(n, cnt, tst):
    if n==C:
        if len(tst) == L and cnt >= 1 and L-cnt>=2:
            print(tst)
        return

    dfs(n+1, cnt+tbl[ord(lst[n])],tst+lst[n])
    dfs(n+1, cnt, tst)

L, C = map(int,input().split())
lst = sorted(input().split())
tbl = [0]*128
for ch in "aeiou":
    tbl[ord(ch)] = 1 #아스키코드
dfs(0,0,"")