# 트리의 부모 찾기

node_num = int(input())
arr = [[] for _ in range(node_num+1)]
for i in range(node_num-1):
    a, b = map(int,input().split())
    arr[a].append(b)
    arr[b].append(a)

visited = [0 for _ in range(node_num+1)]
parent = [0 for _ in range(node_num+1)]
q = []
q.append(1)

while q:
    x = q.pop()
    if visited[x] != 1:
        visited[x] = 1
        
        for k in arr[x] : 
            if parent[k] == 0:
                parent[k] = x
            q.append(k)

for i in range(2, node_num+1):
    print(parent[i])