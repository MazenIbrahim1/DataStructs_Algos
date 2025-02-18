# A* search with manhattan distance as the heuristic function
import heapq

def mahattan_distance(x, y):
    return abs(x[0] - y[0]) + abs(x[1] - y[1])

def aStar(node):
    pass