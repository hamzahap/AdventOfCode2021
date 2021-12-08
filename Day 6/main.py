import sys
import timeit

file = open('input.txt').readlines()
fishyboi = [0] * 9

for line in file:
  for fishyfishy in line.strip().split(","):
    fishyboi[int(fishyfishy)] += 1


for x in range (256):
  zero = fishyboi[0]
  fishyboi[0:8] = fishyboi[1:]
  fishyboi[6] += zero
  fishyboi[8] = zero

print(sum(fishyboi))

