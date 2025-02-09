# Breadth First Search
# O(V + E)
def bfs(node) -> None:
    if node is None:
        return
    
    visited = set()
    queue = []

    visited.add(node)
    queue.append(node)

    while len(queue) != 0:
        pass