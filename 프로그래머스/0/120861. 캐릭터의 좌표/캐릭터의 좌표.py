def boundary_check(board, dir_x, dir_y, arr):
    ans = arr
    x_end = board[0] // 2
    y_end = board[1] // 2

    if abs(dir_x + arr[0]) > x_end or abs(dir_y + arr[1]) > y_end:
        return ans
    else:
        arr[0] += dir_x
        arr[1] += dir_y

    return ans

def solution(keyinput, board):
    answer = [0,0]
    
    for key in keyinput:

        if key == "left":
            answer = boundary_check(board, -1, 0, answer)

        elif key == "right":
            answer = boundary_check(board, 1, 0, answer)

        elif key == "up":
            answer = boundary_check(board, 0, 1, answer)

        elif key == "down":
            answer = boundary_check(board, 0, -1, answer)

    return answer