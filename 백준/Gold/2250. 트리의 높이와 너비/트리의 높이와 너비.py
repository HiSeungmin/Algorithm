import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
tree = {}
left = {}
right = {}
parent = [0] * (n + 1)

for _ in range(n):
    node, l, r = map(int, input().split())
    left[node] = l
    right[node] = r
    if l != -1:
        parent[l] = node
    if r != -1:
        parent[r] = node

root = 0
for i in range(1, n + 1):
    if parent[i] == 0:
        root = i
        break

level_min = {}
level_max = {}
x = 1  

def inorder(node, level):
    global x
    if node == -1:
        return
    inorder(left[node], level + 1)
    
    if level not in level_min:
        level_min[level] = x
        level_max[level] = x
    else:
        level_min[level] = min(level_min[level], x)
        level_max[level] = max(level_max[level], x)
    x += 1

    inorder(right[node], level + 1)

inorder(root, 1)

max_width = 0
level_ans = 0
for level in level_min:
    width = level_max[level] - level_min[level] + 1
    if width > max_width:
        max_width = width
        level_ans = level
    elif width == max_width and level < level_ans:
        level_ans = level

print(level_ans, max_width)