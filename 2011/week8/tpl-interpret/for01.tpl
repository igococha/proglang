int n;
int a;
int i;
int safety;
int final;

n = 24;
a = 5;
safety = 1;

for (i=21; (i<n) and (safety<=2); i=i+1)
{
   a = a * i;
   write i;
   write a;
   write safety;
   safety = safety + 1;
}
final = a;
write final;
