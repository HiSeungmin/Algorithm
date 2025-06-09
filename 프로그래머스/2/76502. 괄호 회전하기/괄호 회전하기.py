def solution(s):
    cnt = 0
    num = len(s)
    s+=s
    for i in range(num):
        st = []

        for k in range(i, i+num):
            if len(st) == 0:
                st.append(s[k])
            else:
                if st[-1] == "(" and s[k] == ")":
                    st.pop()
                elif st[-1] == "{" and s[k] == "}":
                    st.pop()
                elif st[-1] == "[" and s[k] == "]":
                    st.pop()
                else:
                    st.append(s[k])
        
        if len(st) == 0:
            cnt += 1
    return cnt