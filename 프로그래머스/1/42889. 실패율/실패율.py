def solution(N, stages):
    answer = [0] * (N + 1)
    arr = [0.0] * (N + 1)
    peop = len(stages)

    for stage in stages:
        if stage <= N:
            answer[stage] += 1

    for i in range(1, N + 1):
        if peop == 0:
            arr[i] = 0
        else:
            arr[i] = answer[i] / peop
            peop -= answer[i]

    index = list(range(1, N + 1))

    index.sort(key=lambda x: (-arr[x], x))

    return index