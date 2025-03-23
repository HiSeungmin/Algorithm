cash = int(input())
stock = list(map(int, input().split()))

jun = {'cash':cash, 'stock_cnt':0}
min = {'cash':cash, 'stock_cnt':0}

# BNP
for i in stock:
    jun_c = jun['cash']
    
    if jun_c == 0:
        break
    if (jun_c // i) <= 0:
        continue

    jun['cash'] -= (jun_c // i)*i 
    jun['stock_cnt'] += (jun_c // i)
    

# TIMING
prev = stock[0]
sell = 0
buy = 0
for i in range(1, len(stock)):
    min_c = min['cash']
    min_s = min['stock_cnt']
    
    if prev < stock[i]:
        sell += 1
        buy = 0
    elif prev > stock[i]:
        buy += 1
        sell = 0
    else:
        sell = 0
        buy = 0
    
    if sell >= 3:
        if min_s > 0:
            min['cash'] += (stock[i]*min_s)
            min['stock_cnt'] = 0
    elif buy >= 3:
        if (min_c // stock[i]) <= 0:
            continue
        min['cash'] -= (min_c // stock[i])*stock[i] 
        min['stock_cnt'] += (min_c // stock[i])
    
    prev = stock[i]
    

# compare
jun_price = jun['cash'] + (stock[-1]*jun['stock_cnt'])
min_price = min['cash'] + (stock[-1]*min['stock_cnt'])

if jun_price == min_price:
    print('SAMESAME')
elif jun_price > min_price:
    print('BNP')
else:
    print('TIMING')