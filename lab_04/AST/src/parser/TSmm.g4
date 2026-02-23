grammar TSmm;	

// -----------------------------------
// ANALISIS SINTÁCTICO

program: definition* definitionMain EOF
       ;

definition: variableDefinition
          | functionDefinition
          ;

variableDefinition: 'let' ID (',' ID)* ':' type ';'
                  ;

functionDefinition: 'function' ID '(' params? ')' ':' (type | 'void') functionBody
                  ;

params: ID ':' type (',' ID ':' type)*
      ;

functionBody: '{' variableDefinition* statement* '}'
            ;

definitionMain: 'function' 'main' '(' ')' ':' 'void' functionBody
              ;

simple_type: 'int'
           | 'number'
           | 'char'
           ;

type: simple_type
    | '[' INT_CONSTANT ']' type     // ArrayType
    | '[' record_field+ ']'         // RecordType
    ;

record_field: 'let' ID ':' type ';'
            ;

statement: 'log' expression (',' expression)* ';'           // Log
         | 'input' expression (',' expression)* ';'         // Input
         | ID '(' (expression (',' expression)*)? ')' ';'   // FuncCall
         | expression '=' expression ';'                    // Assignment
         | 'if' '(' expression ')' block ('else' block)?    // If-Else
         | 'while' '(' expression ')' block                 // While
         | 'return' expression ';'                          // Return
         ;

block: statement
    | '{' statement+ '}'
    ;

expression: '(' expression ')'                              // Paréntesis
          | ID '(' (expression (',' expression)*)? ')'      // FuncCall
          | expression '[' expression ']'                   // ArrayAccess
          | expression '.' ID                               // FieldAccess
          | '(' expression 'as' simple_type ')'             // Cast
          | '-' expression                                  // UnaryMinus
          | '!' expression                                  // UnaryNot
          | expression ('*' | '/' | '%') expression         // Arithmetic BinaryOp
          | expression ('+' | '-') expression               // Arithmetic BinaryOp
          | expression ('>' | '>=' | '<' | '<=' | '!=' | '==') expression   // Comparison BinaryOp
          | expression ('&&' | '||') expression             // Logic BinaryOp
          | INT_CONSTANT                                    // IntLiteral
          | REAL_CONSTANT                                   // RealLiteral
          | CHAR_CONSTANT                                   // CharLiteral
          | ID                                              // Variable
          ;

// -----------------------------------
// ANALISIS LÉXICO

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

