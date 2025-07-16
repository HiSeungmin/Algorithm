import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline

def build_preorder(in_start, in_end, post_start, post_end):
    if in_start > in_end:
        return

    root = postorder[post_end]
    print(root, end=" ")

    root_idx = inorder_index[root]
    left_size = root_idx - in_start

    build_preorder(in_start, root_idx - 1,
                   post_start, post_start + left_size - 1)

    build_preorder(root_idx + 1, in_end,
                   post_start + left_size, post_end - 1)

n = int(input())
inorder = list(map(int, input().split()))
postorder = list(map(int, input().split()))

inorder_index = {value: idx for idx, value in enumerate(inorder)}
build_preorder(0, n - 1, 0, n - 1)