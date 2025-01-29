# Questions 1.1 - 1.9

# 1.1 -- Is Unique
# Implement an algorithm to determine if a string has all unique characters. What if you
# cannot use additional data structures?
def isUnique(string):
    # Using a set data structure --> O(n)
    return len(string) == len(set(string))

def isUnique2(string):
    # Without using a data structure --> O(n^2)
    for i in range(len(string)):
        for j in range(i+1, len(string)):
            if string[i] == string[j]:
                return False
    return True


# 1.2 -- Check Permutations
# Given two strings, write a method to determine if one is a permutation of the other.
def isPermutation(string1, string2):
    pass


# 1.3 -- URLify 
# Write a method to replace all spaces in a string with '%20'. You may assume that the string
# has sufficient space at the end to hold the additional characters, and that you are given the "true"
# length of the string. (Note: If implementing in Java, please use a character array so that you can
# perform this operation in place.)
def URLify(string):
    pass
