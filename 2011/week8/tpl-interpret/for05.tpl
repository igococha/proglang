int i;
int n;
int fact;
int safety;

n = 6;
fact=1;
safety = 0;

for(i=1; (i<=n) and (safety<10); i=i+1){
         fact = fact*i;
         safety = safety + 1;
         write i;
}
write fact ;
