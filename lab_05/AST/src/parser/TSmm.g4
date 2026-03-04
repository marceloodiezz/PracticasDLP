grammar TSmm;	

@header{
    import ast.*;
    import ast.definition.*;
    import ast.expression.*;
    import ast.program.*;
    import ast.statement.*;
    import ast.type.*;
}

// -----------------------------------
// ANALISIS SINTÁCTICO

program returns [Program ast] locals [List<Definition> defs = new ArrayList<>()]:
       (d=definition { $defs.addAll($d.ast); } )*
       dM=definitionMain { $defs.add($dM.ast); }
       EOF { $ast = new Program($defs); }
       ;

definition returns [List<Definition> ast = new ArrayList<>()]:
          vD=variableDefinition { $ast.addAll($vD.ast); }
          | fD=functionDefinition { $ast.add($fD.ast); }
          ;

variableDefinition returns [List<VarDef> ast = new ArrayList<>()] :
                  'let' vs=variables ':' t=type ';'
                      {
                          for(Variable v : $vs.ast) {
                              VarDef varDef = new VarDef(v.getName(), $t.ast, v.getLine(), v.getColumn());
                              $ast.add(varDef);
                          }
                      }
                  ;

variables returns [List<Variable> ast = new ArrayList<>()] :
         id1=ID
             { $ast.add(new Variable($id1.getText(),
                                     $id1.getLine(),
                                     $id1.getCharPositionInLine()+1)); }
         (',' id2=ID
             { $ast.add(new Variable($id2.getText(),
                                     $id2.getLine(),
                                     $id2.getCharPositionInLine()+1)); }
         )*
         ;

functionDefinition returns [FuncDef ast] locals [List<VarDef> prms = new ArrayList<>(), Type returnType] :
                  'function'
                  name=ID
                  '(' (p=params { $prms = $p.ast; } )? ')' ':'
                  (
                      st=simple_type { $returnType = $st.ast; }
                      | 'void' { $returnType = VoidType.getInstance(); }
                  )
                  b1=functionBody
                      {
                          FuncType fType = new FuncType($returnType, $prms);
                          $ast = new FuncDef($name.getText(),
                                             fType,
                                             $b1.ast,
                                             $name.getLine(),
                                             $name.getCharPositionInLine()+1);
                      }
                  ;

params returns [List<VarDef> ast = new ArrayList<>()] :
      id1=ID ':' st1=simple_type
          { $ast.add(new VarDef($id1.getText(),
                                $st1.ast,
                                $id1.getLine(),
                                $id1.getCharPositionInLine()+1)); }
      (',' id2=ID ':' st2=simple_type
          { $ast.add(new VarDef($id2.getText(),
                                $st2.ast,
                                $id2.getLine(),
                                $id2.getCharPositionInLine()+1)); }
      )*
      ;

functionBody returns [List<Statement> ast = new ArrayList<>()] locals [List<VarDef> varDefs = new ArrayList<>(),
                                                                       List<Statement> statements = new ArrayList<>()] :
            '{'
            (vD=variableDefinition { $varDefs.addAll($vD.ast); })*
            (s=statement { $statements.addAll($s.ast); })*
            '}'
                {
                    $ast.addAll($varDefs);
                    $ast.addAll($statements);
                }
            ;

definitionMain returns [FuncDef ast]:
              'function' name='ast' '(' ')' ':' 'void' b1=functionBody
                  {
                      List<VarDef> params = new ArrayList<>();
                      Type fType = new FuncType(VoidType.getInstance(), params);
                      $ast = new FuncDef($name.getText(),
                                         fType,
                                         $b1.ast,
                                         $name.getLine(),
                                         $name.getCharPositionInLine()+1);
                  }
              ;

simple_type returns [Type ast] :
           // IntType
           'int' { $ast = IntType.getInstance(); }
           // NumberType
           | 'number' { $ast = NumberType.getInstance(); }
           // CharType
           | 'char' { $ast = CharType.getInstance(); }
           ;

type returns [Type ast] locals [List<RecordField> recordFields = new ArrayList<>()] :
    // SimpleType
    st=simple_type
        { $ast = $st.ast; }
    // ArrayType
    | '[' INT_CONSTANT ']' t=type
        { $ast = new ArrayType(LexerHelper.lexemeToInt($INT_CONSTANT.getText()),
                               $t.ast); }
    // RecordType
    | '[' (rF=record_field { $recordFields.add($rF.ast); })+ ']'
        { $ast = new RecordType($recordFields); }
    ;

record_field returns [RecordField ast] :
            // RecordField
            'let' ID ':' t=type ';'
                { $ast = new RecordField($ID.getText(),
                                         $t.ast); }
            ;

statement returns [List<Statement> ast = new ArrayList<>()] locals [List<Expression> args = new ArrayList<>(),
                                                                    List<Statement> elseBlock = new ArrayList<>()] :
         // Log
         'log' e1=expression { $ast.add(new Log($e1.ast, $e1.ast.getLine(), $e1.ast.getColumn())); }
         (',' e2=expression { $ast.add(new Log($e2.ast, $e2.ast.getLine(), $e2.ast.getColumn())); } )* ';'
         // Input
         | 'input' e1=expression { $ast.add(new Input($e1.ast, $e1.ast.getLine(), $e1.ast.getColumn())); }
           (',' e2=expression { $ast.add(new Input($e2.ast, $e2.ast.getLine(), $e2.ast.getColumn())); } )* ';'
         // FuncCall
         | ID '(' (e1=expression { $args.add($e1.ast); } (',' e2=expression { $args.add($e2.ast); })*)? ')' ';'
             {
                 Variable var = new Variable($ID.getText(), $ID.getLine(), $ID.getCharPositionInLine()+1);
                 $ast.add(new FuncCall($args,
                                       var,
                                       $ID.getLine(),
                                       $ID.getCharPositionInLine()+1));
             }
         // Assignment
         | e1=expression '=' e2=expression ';'
             { $ast.add(new Assignment($e1.ast,
                                       $e2.ast,
                                       $e1.ast.getLine(),
                                       $e1.ast.getColumn())); }
         // If-Else
         | 'if' '(' e1=expression ')' b1=block ('else' b2=block { $elseBlock = $b2.ast; } )?
             { $ast.add(new IfElse($e1.ast,
                                   $b1.ast,
                                   $elseBlock,
                                   $e1.ast.getLine(),
                                   $e1.ast.getColumn())); }
         // While
         | 'while' '(' e1=expression ')' b1=block
             { $ast.add(new While($e1.ast,
                                  $b1.ast,
                                  $e1.ast.getLine(),
                                  $e1.ast.getColumn())); }
         // Return
         | 'return' e1=expression ';'
             { $ast.add(new Return($e1.ast,
                                   $e1.ast.getLine(),
                                   $e1.ast.getColumn())); }
         ;

block returns [List<Statement> ast = new ArrayList<>()] :
     s1=statement { $ast.addAll($s1.ast); }
     | '{' (s1=statement { $ast.addAll($s1.ast); })+ '}'
     ;

expression returns [Expression ast] locals [List<Expression> args = new ArrayList<>()] :
          // Paréntesis
          '(' e1=expression ')'
              { $ast = $e1.ast; }
          // FuncCall
          | ID '(' (e1=expression { $args.add($e1.ast); } (',' e2=expression { $args.add($e2.ast); } )*)? ')'
              {
                  Variable var = new Variable($ID.getText(), $ID.getLine(), $ID.getCharPositionInLine()+1);
                  $ast = new FuncCall($args,
                                      var,
                                      $ID.getLine(),
                                      $ID.getCharPositionInLine()+1);
              }
          // ArrayAccess
          | e1=expression '[' e2=expression ']'
              { $ast = new ArrayAccess($e1.ast,
                                       $e2.ast,
                                       $e1.ast.getLine(),
                                       $e1.ast.getColumn()); }
          // FieldAccess
          | e1=expression '.' ID
              { $ast = new FieldAccess($ID.getText(),
                                       $e1.ast,
                                       $e1.ast.getLine(),
                                       $e1.ast.getColumn()); }
          // Cast
          | '(' e1=expression 'as' t1=simple_type ')'
              { $ast = new Cast($t1.ast,
                                $e1.ast,
                                $e1.ast.getLine(),
                                $e1.ast.getColumn()); }
          // UnaryMinus
          | '-' e1=expression
              { $ast = new UnaryMinus($e1.ast,
                                      $e1.ast.getLine(),
                                      $e1.ast.getColumn()); }
          // UnaryNot
          | '!' e1=expression
              { $ast = new UnaryNot($e1.ast,
                                    $e1.ast.getLine(),
                                    $e1.ast.getColumn()); }
          // Arithmetic BinaryOp
          | e1=expression OP=('*' | '/' | '%') e2=expression
              { $ast = new ArithmeticOp($OP.getText(),
                                        $e1.ast,
                                        $e2.ast,
                                        $e1.ast.getLine(),
                                        $e1.ast.getColumn()); }
          // Arithmetic BinaryOp
          | e1=expression OP=('+' | '-') e2=expression
              { $ast = new ArithmeticOp($OP.getText(),
                                        $e1.ast,
                                        $e2.ast,
                                        $e1.ast.getLine(),
                                        $e1.ast.getColumn()); }
          // Comparison BinaryOp
          | e1=expression OP=('>' | '>=' | '<' | '<=' | '!=' | '==') e2=expression
              { $ast = new ComparisonOp($OP.getText(),
                                        $e1.ast,
                                        $e2.ast,
                                        $e1.ast.getLine(),
                                        $e1.ast.getColumn()); }
          // Logic BinaryOp
          | e1=expression OP=('&&' | '||') e2=expression
              { $ast = new LogicOp($OP.getText(),
                                   $e1.ast,
                                   $e2.ast,
                                   $e1.ast.getLine(),
                                   $e1.ast.getColumn()); }
          // IntLiteral
          | INT_CONSTANT
              { $ast = new IntLiteral(LexerHelper.lexemeToInt($INT_CONSTANT.getText()),
                                      $INT_CONSTANT.getLine(),
                                      $INT_CONSTANT.getCharPositionInLine()+1); }
          // RealLiteral
          | REAL_CONSTANT
              { $ast = new NumberLiteral(LexerHelper.lexemeToReal($REAL_CONSTANT.getText()),
                                         $REAL_CONSTANT.getLine(),
                                         $REAL_CONSTANT.getCharPositionInLine()+1); }
          // CharLiteral
          | CHAR_CONSTANT
              { $ast = new CharLiteral(LexerHelper.lexemeToChar($CHAR_CONSTANT.getText()),
                                       $CHAR_CONSTANT.getLine(),
                                       $CHAR_CONSTANT.getCharPositionInLine()+1); }
          // Variable
          | ID
              { $ast = new Variable($ID.getText(),
                                    $ID.getLine(),
                                    $ID.getCharPositionInLine()+1); }
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

