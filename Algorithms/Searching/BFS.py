# Breadth First Search
# O(V + E)
def bfs(node) -> None:
    if node is None:
        return
    
    visited = set()
    queue = []

    visited.add(node)
    queue.append(node)

    while queue:
        current = queue.pop(0)
        print('Vertex:', current)

        for neighbor in current.neighbors:
            if neighbor not in visited:
                visited.add(neighbor)
                queue.append(neighbor)