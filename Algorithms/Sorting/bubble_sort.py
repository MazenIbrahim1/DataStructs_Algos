# Bubble Sort
# Time Complexity: O(n^2)

def bubble_sort(lst: list):
    for i in range(1, len(lst)):
        for j in range(len(lst) - 1):
            if lst[j] > lst[j+1]:
                # Swap
                lst[j], lst[j+1] = lst[j+1], lst[j]

# Test
arr = [12, 11, 13, 5, 6]
arr2 = [2,8,5,3,9,4,1]
bubble_sort(arr)
bubble_sort(arr2)
print(arr)
print(arr2)