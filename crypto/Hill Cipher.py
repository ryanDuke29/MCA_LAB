key = [
    [6,24,1],
    [13,16,10],
    [20,17,15]
]

plain = input("Enter 3 plain text letter: ").upper()

p = [ord(ch)-ord('A') for ch in plain]

for i in range(3):
    c = (
        key[i][0]*p[0]+
        key[i][1]*p[1]+
        key[i][2]*p[2]
    )%26
    output = chr(c+ord('A'))
    

print("Cipher Text: ",output)