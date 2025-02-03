# Insertion Sort
# Time Complexity: O(n^2)

def insertion_sort(lst):
    n = len(lst)

    for i in range(1, n):
        key = lst[i]
        j = i - 1

        while j >= 0 and key < lst[j]:
            # shift elements to right
            lst[j+1] = lst[j]
            j -= 1
            
        lst[j+1] = key    

# Test
arr = [12, 11, 13, 5, 6]
insertion_sort(arr)
print(arr)