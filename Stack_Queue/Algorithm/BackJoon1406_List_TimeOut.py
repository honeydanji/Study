import sys
input=sys.stdin.readline

# 문자열 입력
input_string = input()
input_list = list(input_string)

# 커서 위치
cursor = len(input_list)

# 반복횟수 입력
n = int(input())

# 해결
for _ in range(n) :
    s = input().split()

    if s[0] == "L" :
        if cursor != 0 :
            cursor -= 1
    elif s[0] == "D" :
        if cursor != len(input_list) :
            cursor += 1
    elif s[0] == "B" :
        if cursor != 0 :
            cursor -= 1
            input_list.remove(cursor)
    elif s[0] == "P":
        input_list.insert(cursor, s[1])
        cursor += 1

result = ''.join(input_list)
print(result)
