def linear_search(num, list):
    for i in range(len(list)):
        if list[i] == num:
            return i
    return "key값이 존재하지 않습니다."

print(linear_search(2, [2,3,4,5,6]))
print(linear_search(2, [1,3,4,5,6]))