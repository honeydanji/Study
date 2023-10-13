def binary_search(num, list):
    first = 0
    last = len(list) - 1

    while first <= last :
        center = int((first + last) / 2)
        if num == list[center] :
            return "찾는 값의 요소는 " + str(center) + "입니다."
        elif num > list[center] :
            first = center + 1
        elif num < list[center] :
            last = center - 1

    return "값이 존재하지 않습니다."

print(binary_search(4, [2,3,5,7,11]))
print(binary_search(2, [2,3,5,7,11]))