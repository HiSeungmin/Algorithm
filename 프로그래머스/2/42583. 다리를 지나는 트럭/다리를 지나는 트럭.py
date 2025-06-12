import queue

def solution(bridge_length, weight, truck_weights):
    q = queue.Queue()
    sum = 0
    time = 0
    for i in range(len(truck_weights)):
        truck = truck_weights[i]

        while True:
            if(q.qsize() == 0):
                q.put(truck)
                sum += truck
                time += 1
                break
            elif q.qsize() == bridge_length:
                sum -= q.get()
            else:
                if sum+truck <= weight:
                    q.put(truck)
                    sum += truck
                    time += 1
                    break
                else:
                    q.put(0)
                    time+=1

    return time+bridge_length