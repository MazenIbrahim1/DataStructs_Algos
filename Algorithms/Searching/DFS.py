# Depth First Search
# O(V + E)
def dfs(node):
    if node is None:
        return
    
    visited = set()
    stack = []

    visited.add(node)
    stack.append(node)
    while stack:
        current = stack.pop()
        print('Vertex:', current) 

        for neighbor in current.neighbors:
            if neighbor not in visited:
                visited.add(neighbor)
                stack.append(neighbor)