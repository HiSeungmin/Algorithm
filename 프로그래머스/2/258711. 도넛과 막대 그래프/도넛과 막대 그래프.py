def solution(edges):
    answer = [0, 0, 0, 0]
    max_val = max(map(max, edges)) + 1
    in_cnt, out_cnt = [0] * max_val, [0] * max_val
        
    for now_out, now_in in edges:
        out_cnt[now_out] += 1
        in_cnt[now_in] += 1
        
    for now_node in range(1, max_val):
        if in_cnt[now_node] == 0 and out_cnt[now_node] >= 2:
            answer[0] = now_node 
        elif in_cnt[now_node] >= 1 and out_cnt[now_node] == 0:
            answer[2] += 1
        elif in_cnt[now_node] >= 2 and out_cnt[now_node] == 2:
            answer[3] += 1
    answer[1] = out_cnt[answer[0]] - sum(answer[2:])
    return answer