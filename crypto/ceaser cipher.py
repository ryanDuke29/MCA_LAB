def encrypt(text, shift):
    result = ""

    for ch in text:
        if ch.isalpha():
            base = ord('A') if ch.isupper() else ord('a')
            result += chr((ord(ch) - base + shift) % 26 + base)
        else:
            result += ch

    return result

def decrypt(text,shift):
    return encrypt(text,-shift)

print("Ceaser Cipher\n")
message = input("Enter the message for Encryption: ")
shift = int(input("Enter the shift value: "))
encrypted = encrypt(message,shift)
print("Encrypted: ",encrypted)

decrypted = decrypt(encrypted,shift)
print("Decrypted: ",decrypted)