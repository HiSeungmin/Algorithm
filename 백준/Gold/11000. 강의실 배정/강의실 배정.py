import heapq
n = int(input())
arr =[]
room = []
for _ in range(n):
    arr.append(list(map(int,input().split(' '))))

arr.sort()
heapq.heappush(room, arr[0][1])

for k in range(1,n):
    if arr[k][0] < room[0]:
        heapq.heappush(room,arr[k][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room,arr[k][1])

print(len(room))