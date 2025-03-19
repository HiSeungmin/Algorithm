N, C = map(int, input().split())
home = []

for i in range(N):
    home.append(int(input()))

home.sort()

def binary_search(array, start, end):
    while start <= end:
        mid = (start+end)//2
        current = array[0]
        count = 1

        for i in range(1, len(array)):
            if array[i] >= current + mid:
                count += 1
                current = array[i]

        if count >= C:
            global answer
            start = mid+1
            answer = mid
        else:
            end = mid-1

start = 1
end = home[-1] - home[0]
answer = 0

binary_search(home, start, end)
print(answer)