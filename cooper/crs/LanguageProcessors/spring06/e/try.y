
%token if then else
%left '+' '-'
%left '&'
%left '|'

%%
/*E : '(' E ')'
;*/
E : E '-' E
  | 'a'
/*  | bexp*/
   | E '&' E
     | E '|' E
;

