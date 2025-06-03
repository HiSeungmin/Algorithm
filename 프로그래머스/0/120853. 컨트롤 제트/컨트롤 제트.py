def solution(s):
    answer = 0
    arr = list(s.split(' '))
    st = []
    for i in arr:
        if i == 'Z':
            st.pop()
        else:
            st.append(int(i))
    
    answer = sum(st)

    return answer