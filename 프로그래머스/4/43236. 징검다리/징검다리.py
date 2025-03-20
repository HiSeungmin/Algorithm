def solution(distance, rocks, n):
    answer = 0
    
    rocks.append(distance)
    rocks.sort()
    
    left, right = 0, distance  
    
    while left <= right:
        
        mid = (left + right) // 2  
        min_distance = distance 
        current = 0  
        count = 0  
        
        for rock in rocks:
            diff = rock - current  
            if diff < mid:  
                count += 1
            else:  
                current = rock  
                min_distance = min(min_distance, diff)  
        
        if count > n:  
            right = mid - 1
        else:  
            answer = min_distance
            left = mid + 1

    return answer