import heapq

N = int(input())
cards = [int(input()) for _ in range(N)]
heapq.heapify(cards)
cnt = 0

while len(cards) > 1:
    tmp = heapq.heappop(cards) + heapq.heappop(cards)
    heapq.heappush(cards, tmp)
    cnt += tmp
    
print(cnt)