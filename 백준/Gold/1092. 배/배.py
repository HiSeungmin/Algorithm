cNum = int(input())
cranes = list(map(int, input().split()))
bNum = int(input())
boxes = list(map(int, input().split()))

cranes.sort(reverse=True)
boxes.sort(reverse=True)

if cranes[0] < boxes[0]:
    print(-1)
    exit(0)

cnt = 0

while boxes:
    for crane in cranes:
        for box in boxes:
            if crane >= box:
                boxes.remove(box)
                break
    cnt += 1

print(cnt)