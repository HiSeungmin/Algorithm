import sys

N = int(sys.stdin.readline().strip())  
arr = list(map(int, sys.stdin.readline().split()))

sorted_unique = sorted(set(arr))
index_map = {value: idx for idx, value in enumerate(sorted_unique)}
print(" ".join(str(index_map[num]) for num in arr))