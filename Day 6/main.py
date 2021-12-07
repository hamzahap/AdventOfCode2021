import sys

file = sys.argv[1] if len(sys.argv)>1 else 'inputexample.txt'

for line in open(file):
  fishyboi = list(line.split(","))
fishyboi = [int(x) for x in fishyboi]
for x in range (256):
  for y in range(len(fishyboi)):
    fishyboi[y] -= 1
    if fishyboi[y] == -1:
      fishyboi.append(8)
      fishyboi[y] = 6

print(len(fishyboi))
