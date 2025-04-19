def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def to_irreducible(a, b):
    g = gcd(a, b)
    return a // g, b // g

a, b = map(int, input().split())
c, d = map(int, input().split())

ir = (a*d) + (b*c)
ik = b*d

re1, re2 = to_irreducible(ir, ik)
print(re1, re2)