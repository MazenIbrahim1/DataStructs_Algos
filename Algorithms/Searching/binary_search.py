# Binary Search Algorithm

def binary_search(arr, target):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
    return -1

arr1 = [1, 3, 5, 7, 9, 11, 13]
print(binary_search(arr1, 7))  # Expected output: 3
print(binary_search(arr1, 1))  # Expected output: 0
print(binary_search(arr1, 13)) # Expected output: 6
print(binary_search(arr1, 6))  # Expected output: -1 (not found)
print(binary_search([], 5))    # Expected output: -1 (empty array)
print(binary_search([4], 4))   # Expected output: 0 (single element, match)
print(binary_search([4], 5))   # Expected output: -1 (single element, no match)
print(binary_search([2, 4, 6, 8, 10], 10))  # Expected output: 4