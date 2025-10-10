def cal_date(date, month):
    year, mon, day = map(int, date.split('.'))
    total_days = year * 12 * 28 + mon * 28 + day
    total_days += month * 28 - 1
    return total_days

def is_expired(today_days, expire_days):
    return today_days > expire_days

def solution(today, terms, privacies):
    answer = []
    y, m, d = map(int, today.split('.'))
    today_days = y * 12 * 28 + m * 28 + d
    
    dic_terms = {}
    for term in terms:
        t, c = term.split(' ')
        dic_terms[t] = int(c)
    
    for idx, privacy in enumerate(privacies):
        date, t = privacy.split(' ')
        expired_days = cal_date(date, dic_terms[t])
        if is_expired(today_days, expired_days):
            answer.append(idx + 1)
    
    return answer