# Selection Sort
# Time Complexity: O(n^2)

def selection_sort(lst: list):
    curr_min_index = 0

    for i in range(len(lst)):
        curr_min_index = i
        for j in range(i+1 ,len(lst)):
            if lst[j] < lst[curr_min_index]:
                curr_min_index = j
        if curr_min_index != i:
            # Swap elements
            lst[i], lst[curr_min_index] = lst[curr_min_index], lst[i]

# Test
arr = [12, 11, 13, 5, 6]
arr2 = [2,8,5,3,9,4,1]
selection_sort(arr)
selection_sort(arr2)
print(arr)
print(arr2)