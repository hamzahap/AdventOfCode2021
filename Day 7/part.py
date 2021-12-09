import numpy as np
hpos = np.array([int(i) for i in open("input.txt").read().split(",")])
fuel = np.abs(hpos - int(np.mean(hpos))) * (np.abs(hpos - int(np.mean(hpos))) + 1) // 2
print(np.sum(fuel))