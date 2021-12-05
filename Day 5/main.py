from collections import defaultdict
import sys

file = sys.argv[1] if len(sys.argv)>1 else 'input.txt'

D1 = defaultdict(int)
D2 = defaultdict(int)
for line in open(file):
    left,right = line.split('->')
    x1,y1 = left.split(',')
    x2,y2 = right.split(',')
    x1 = int(x1)
    y1 = int(y1)
    x2 = int(x2)
    y2 = int(y2)
    dx = x2-x1
    dy = y2-y1

    for i in range(max(abs(dx),abs(dy))+1):
        if(dx>0):
          x = x1 + 1*i
        else:
          if(dx<0):
            x = x1 + -1*i
          else:
            x = x1
        if(dy>0):
          y = y1 + 1*i
        else:
          if(dy<0):
            y = y1 + -1*i
          else:
            y = y1
        if dx == 0 or dy == 0:
            D1[(x,y)] += 1
        D2[(x,y)] += 1
part1 = 0
part2 = 0
for k in D1:
  if (D1[k]>1):
    part1+=1
for k in D2:
  if (D2[k]>1):
    part2+=1
print(part1)
print(part2)