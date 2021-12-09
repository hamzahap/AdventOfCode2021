import numpy as np
hpos = np.array([int(i) for i in open("input.txt").read().split(",")])
fuel = np.abs(hpos-np.median(hpos))
answer = int(np.sum(fuel))
print(answer)