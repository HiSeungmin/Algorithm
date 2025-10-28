n = int(input())
neg_arr=[]
pos_arr=[]
neg_num = 0
sum = 0
for _ in range(n):
    num = int(input())
    if num > 0:
        pos_arr.append(num)
    else:
        neg_arr.append(num)

pos_arr.sort()
neg_arr.sort()
neg_arr.reverse()

while len(neg_arr) > 1:
    a = neg_arr.pop()
    b = neg_arr.pop()
    sum += max(a*b,a+b)

while len(pos_arr) > 1:
    a = pos_arr.pop()
    b = pos_arr.pop()
    sum += max(a*b,a+b)

if len(neg_arr) == 1:
    last = neg_arr.pop()
    sum += last
if len(pos_arr) == 1:
    last = pos_arr.pop()
    sum += last
    
print(sum)