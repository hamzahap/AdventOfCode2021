import sys
import numpy as np

file = sys.argv[1] if len(sys.argv)>1 else 'input.txt'

for line in open(file):
  fishyboi = np.array(line.strip().split(","))
fishyboi = fishyboi.astype(int)
for x in range (256):
  for y in range(fishyboi.size):
    fishyboi[y] -= 1
    if fishyboi[y] == -1:
      fishyboi = np.append(fishyboi,8)
      fishyboi[y] = 6

print(fishyboi.size)
