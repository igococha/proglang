
int val;
int sqrt;

read val;

sqrt = 1;

while (sqrt * sqrt <= val and ((sqrt + 1) * (sqrt + 1)) <= val)
  { sqrt = sqrt + 1; }

write sqrt;
