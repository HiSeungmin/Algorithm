def solution(number, k):

    stack = []
    for v in number:
        while stack and stack[-1] < v and k>0:
            stack.pop()
            k -= 1
        stack.append(v)

    if k > 0:
        stack = stack[:-k]
    return ''.join(stack)