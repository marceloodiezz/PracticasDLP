grammar TSmm;	

program: 
       ;

fragment
DIGIT: [0-9];

fragment
LETTER: [a-zA-Z]
    ;

fragment
BASE: INT_CONSTANT* '.' DIGIT*
    ;

fragment
EXP: [eE] [+-]? DIGIT+
   ;

fragment ESCAPED_CHAR
    : '\\' ('n' | 't' | [0-9]+)
    ;

WHITE: [ \n\t\r]+ -> skip
     ;

COMMENTS: ('//' ~[\r\n]*
        | '/*' .*? '*/') -> skip
        ;

REAL_CONSTANT: (INT_CONSTANT* '.' DIGIT*) EXP?
             | INT_CONSTANT EXP
             ;
  		 
INT_CONSTANT: [1-9] DIGIT*
            | '0'
            ;

CHAR_CONSTANT: '\'' (ESCAPED_CHAR | ~['\\\r\n]) '\''
             ;

ID: LETTER (LETTER | DIGIT | '_')*
  | '_' (LETTER | DIGIT | '_')*
  ;

