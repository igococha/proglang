int n;
int a;
int i;
int safety;

n = 4;
a = 5;
safety = 0;

for (i=1; (i<n) ; i=i+1)
{
   a = a * n;
   safety = safety + 1;
   write i;
}

write a;