def solution(s):
    st = []
    for i in s:
        if i=="(":
            st.append(i)
        elif i==")" and len(st) == 0:
            return False
        else:
            st.pop()
    
    if len(st) > 0:
        return False
    else:
        return True