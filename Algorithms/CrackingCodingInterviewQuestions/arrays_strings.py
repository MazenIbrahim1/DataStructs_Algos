# Questions 1.1 - 1.9

# 1.1 -- Is Unique
# Implement an algorithm to determine if a string has all unique characters. What if you
# cannot use additional data structures?
def isUnique(string):
    # Time and Space --> O(n)
    return len(string) == len(set(string))

# Brute Force
def isUnique2(string):
    # Time --> O(n^2)
    for i in range(len(string)):
        for j in range(i+1, len(string)):
            if string[i] == string[j]:
                return False
    return True


# 1.2 -- Check Permutations
# Given two strings, write a method to determine if one is a permutation of the other.
def isPermutation(string1, string2):
    # O(n log n)
    return sorted(string1) == sorted(string2)

# Optimized Version
def isPermutation2(string1, string2):
    pass


# 1.3 -- URLify 
# Write a method to replace all spaces in a string with '%20'. You may assume that the string
# has sufficient space at the end to hold the additional characters, and that you are given the "true"
# length of the string. (Note: If implementing in Java, please use a character array so that you can
# perform this operation in place.)
def URLify(string):
    pass


# Main 
def main():
    # Test isUnique and isUnique2
    test_strings = ["abcdef", "aabbcc", "123456", "112233"]
    for s in test_strings:
        print(f"isUnique('{s}'): {isUnique(s)}")
        print(f"isUnique2('{s}'): {isUnique2(s)}")

    # Test isPermutation
    test_pairs = [("abc", "bca"), ("abc", "def"), ("123", "321"), ("123", "456")]
    for s1, s2 in test_pairs:
        print(f"isPermutation('{s1}', '{s2}'): {isPermutation(s1, s2)}")

    # Test URLify
    test_urls = [("Mr John Smith    ", 13), ("Hello World  ", 11)]
    for s, true_length in test_urls:
        print(f"URLify('{s}', {true_length}): {URLify(s[:true_length])}")

if __name__ == "__main__":
    main()