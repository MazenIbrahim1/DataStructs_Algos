# Depth First Search
# O(V + E)
def dfs(node):
    if node is None:
        return
    
    visited = set()
    stack = []

    visited.add(node)
    stack.append(node)

    while len(stack) != 0:
        pass