a = 1
b = 3
p = 7 #prime number

print("Elliptice Curve \n Point on curve")

for x in range(p):
    rhs = (x ** 3+ a * x+b)%p
    for y in range(p):
        if(y * y)%p ==rhs:
            print(f"({x},{y})")
print("point at Infinity")