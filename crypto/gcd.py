a = 36842
b = 25410

while(a%b != 0):
    x = a % b
    y = a/b

    a = b
    b= x

print("GCD: ",b)
