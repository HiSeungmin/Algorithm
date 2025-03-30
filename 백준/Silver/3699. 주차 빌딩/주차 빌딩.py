T = int(input())
for _ in range(T):
    H, L = map(int,input().split())
    pc = {}

    for i in range(H):
        F = list(map(int,input().split()))

        for j in range(L):
            if F[j] != -1:
                pc[F[j]] = (i+1, j+1)

    floor = sorted(pc.items())

    H2 = [1] *(H+1)
    res = 0

    for i, j in floor:
        res += abs(1-j[0])*20
        res += min(abs(H2[j[0]] - j[1]), abs(L - abs(H2[j[0]] - j[1]))) * 5
        H2[j[0]] = j[1]
    
    print(res)