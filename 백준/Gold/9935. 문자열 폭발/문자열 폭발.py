string = input()
bomb = input()
stack = []

bomb_len = len(bomb)

for ch in string:
    stack.append(ch)

    # 스택의 끝부분이 폭탄 문자열과 같으면 제거
    if len(stack) >= bomb_len:
        if ''.join(stack[-bomb_len:]) == bomb:
            for _ in range(bomb_len):
                stack.pop()

result = ''.join(stack)
print(result if result else "FRULA")