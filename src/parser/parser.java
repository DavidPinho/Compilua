package parser;
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20150326 (SVN rev 63)
//----------------------------------------------------

import java_cup.runtime.*;
import tree.*;
import tree.Number;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20150326 (SVN rev 63) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\055\000\002\002\004\000\002\002\004\000\002\002" +
    "\005\000\002\002\002\000\002\003\005\000\002\003\007" +
    "\000\002\003\003\000\002\003\003\000\002\003\003\000" +
    "\002\004\010\000\002\005\004\000\002\005\002\000\002" +
    "\010\004\000\002\011\005\000\002\011\002\000\002\012" +
    "\003\000\002\012\003\000\002\012\003\000\002\012\005" +
    "\000\002\012\005\000\002\012\004\000\002\006\006\000" +
    "\002\006\010\000\002\007\004\000\002\007\005\000\002" +
    "\007\003\000\002\013\003\000\002\013\003\000\002\013" +
    "\003\000\002\013\003\000\002\013\003\000\002\013\003" +
    "\000\002\013\003\000\002\013\003\000\002\013\003\000" +
    "\002\013\003\000\002\013\003\000\002\013\003\000\002" +
    "\013\003\000\002\013\003\000\002\014\003\000\002\014" +
    "\003\000\002\014\003\000\002\015\004\000\002\015\006" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\106\000\016\002\ufffe\010\ufffe\011\ufffe\016\ufffe\023" +
    "\ufffe\050\ufffe\001\002\000\016\002\007\010\005\011\010" +
    "\016\013\023\016\050\015\001\002\000\016\023\027\043" +
    "\024\044\023\045\021\046\017\050\026\001\002\000\024" +
    "\002\000\004\104\007\000\010\000\011\000\013\000\016" +
    "\000\023\000\050\000\001\002\000\004\002\001\001\002" +
    "\000\016\023\027\043\024\044\023\045\021\046\017\050" +
    "\026\001\002\000\024\002\ufff9\004\ufff9\007\ufff9\010\ufff9" +
    "\011\ufff9\013\ufff9\016\ufff9\023\ufff9\050\ufff9\001\002\000" +
    "\024\002\ufffa\004\ufffa\007\ufffa\010\ufffa\011\ufffa\013\ufffa" +
    "\016\ufffa\023\ufffa\050\ufffa\001\002\000\004\050\072\001" +
    "\002\000\024\002\ufffb\004\ufffb\007\ufffb\010\ufffb\011\ufffb" +
    "\013\ufffb\016\ufffb\023\ufffb\050\ufffb\001\002\000\004\005" +
    "\070\001\002\000\016\023\027\043\024\044\023\045\021" +
    "\046\017\050\026\001\002\000\070\002\ufff2\004\ufff2\006" +
    "\ufff2\007\ufff2\010\ufff2\011\ufff2\012\ufff2\013\ufff2\014\ufff2" +
    "\016\ufff2\023\ufff2\024\ufff2\025\ufff2\026\ufff2\027\ufff2\030" +
    "\ufff2\031\ufff2\032\ufff2\033\ufff2\034\ufff2\035\ufff2\036\ufff2" +
    "\037\ufff2\040\ufff2\041\ufff2\042\ufff2\050\ufff2\001\002\000" +
    "\040\024\067\025\040\026\034\027\032\030\046\031\043" +
    "\032\036\033\047\034\042\035\033\036\037\037\044\040" +
    "\035\041\041\042\050\001\002\000\016\023\uffd9\043\uffd9" +
    "\044\uffd9\045\uffd9\046\uffd9\050\uffd9\001\002\000\070\002" +
    "\ufff0\004\ufff0\006\ufff0\007\ufff0\010\ufff0\011\ufff0\012\ufff0" +
    "\013\ufff0\014\ufff0\016\ufff0\023\ufff0\024\ufff0\025\ufff0\026" +
    "\ufff0\027\ufff0\030\ufff0\031\ufff0\032\ufff0\033\ufff0\034\ufff0" +
    "\035\ufff0\036\ufff0\037\ufff0\040\ufff0\041\ufff0\042\ufff0\050" +
    "\ufff0\001\002\000\016\023\uffd7\043\uffd7\044\uffd7\045\uffd7" +
    "\046\uffd7\050\uffd7\001\002\000\016\023\uffd8\043\uffd8\044" +
    "\uffd8\045\uffd8\046\uffd8\050\uffd8\001\002\000\016\023\027" +
    "\043\024\044\023\045\021\046\017\050\026\001\002\000" +
    "\070\002\ufff1\004\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1" +
    "\012\ufff1\013\ufff1\014\ufff1\016\ufff1\023\ufff1\024\ufff1\025" +
    "\ufff1\026\ufff1\027\ufff1\030\ufff1\031\ufff1\032\ufff1\033\ufff1" +
    "\034\ufff1\035\ufff1\036\ufff1\037\ufff1\040\ufff1\041\ufff1\042" +
    "\ufff1\050\ufff1\001\002\000\016\023\027\043\024\044\023" +
    "\045\021\046\017\050\026\001\002\000\040\024\045\025" +
    "\040\026\034\027\032\030\046\031\043\032\036\033\047" +
    "\034\042\035\033\036\037\037\044\040\035\041\041\042" +
    "\050\001\002\000\016\023\027\043\024\044\023\045\021" +
    "\046\017\050\026\001\002\000\016\023\uffe5\043\uffe5\044" +
    "\uffe5\045\uffe5\046\uffe5\050\uffe5\001\002\000\016\023\uffe1" +
    "\043\uffe1\044\uffe1\045\uffe1\046\uffe1\050\uffe1\001\002\000" +
    "\016\023\uffe6\043\uffe6\044\uffe6\045\uffe6\046\uffe6\050\uffe6" +
    "\001\002\000\016\023\uffdc\043\uffdc\044\uffdc\045\uffdc\046" +
    "\uffdc\050\uffdc\001\002\000\016\023\uffe2\043\uffe2\044\uffe2" +
    "\045\uffe2\046\uffe2\050\uffe2\001\002\000\016\023\uffdf\043" +
    "\uffdf\044\uffdf\045\uffdf\046\uffdf\050\uffdf\001\002\000\016" +
    "\023\uffe7\043\uffe7\044\uffe7\045\uffe7\046\uffe7\050\uffe7\001" +
    "\002\000\016\023\uffdb\043\uffdb\044\uffdb\045\uffdb\046\uffdb" +
    "\050\uffdb\001\002\000\016\023\uffde\043\uffde\044\uffde\045" +
    "\uffde\046\uffde\050\uffde\001\002\000\016\023\uffe3\043\uffe3" +
    "\044\uffe3\045\uffe3\046\uffe3\050\uffe3\001\002\000\016\023" +
    "\uffdd\043\uffdd\044\uffdd\045\uffdd\046\uffdd\050\uffdd\001\002" +
    "\000\074\002\uffef\004\uffef\006\uffef\007\uffef\010\uffef\011" +
    "\uffef\012\uffef\013\uffef\014\uffef\016\uffef\020\053\023\uffef" +
    "\024\uffef\025\uffef\026\uffef\027\uffef\030\uffef\031\uffef\032" +
    "\uffef\033\uffef\034\uffef\035\uffef\036\uffef\037\uffef\040\uffef" +
    "\041\uffef\042\uffef\047\051\050\uffef\001\002\000\016\023" +
    "\uffe4\043\uffe4\044\uffe4\045\uffe4\046\uffe4\050\uffe4\001\002" +
    "\000\016\023\uffe0\043\uffe0\044\uffe0\045\uffe0\046\uffe0\050" +
    "\uffe0\001\002\000\016\023\uffda\043\uffda\044\uffda\045\uffda" +
    "\046\uffda\050\uffda\001\002\000\070\002\uffe8\004\uffe8\006" +
    "\uffe8\007\uffe8\010\uffe8\011\uffe8\012\uffe8\013\uffe8\014\uffe8" +
    "\016\uffe8\023\uffe8\024\uffe8\025\uffe8\026\uffe8\027\uffe8\030" +
    "\uffe8\031\uffe8\032\uffe8\033\uffe8\034\uffe8\035\uffe8\036\uffe8" +
    "\037\uffe8\040\uffe8\041\uffe8\042\uffe8\050\uffe8\001\002\000" +
    "\070\002\uffec\004\uffec\006\uffec\007\uffec\010\uffec\011\uffec" +
    "\012\uffec\013\uffec\014\uffec\016\uffec\023\uffec\024\uffec\025" +
    "\uffec\026\uffec\027\uffec\030\uffec\031\uffec\032\uffec\033\uffec" +
    "\034\uffec\035\uffec\036\uffec\037\uffec\040\uffec\041\uffec\042" +
    "\uffec\050\uffec\001\002\000\004\050\063\001\002\000\020" +
    "\023\ufff3\024\056\043\ufff3\044\ufff3\045\ufff3\046\ufff3\050" +
    "\ufff3\001\002\000\016\023\027\043\024\044\023\045\021" +
    "\046\017\050\026\001\002\000\070\002\uffea\004\uffea\006" +
    "\uffea\007\uffea\010\uffea\011\uffea\012\uffea\013\uffea\014\uffea" +
    "\016\uffea\023\uffea\024\uffea\025\uffea\026\uffea\027\uffea\030" +
    "\uffea\031\uffea\032\uffea\033\uffea\034\uffea\035\uffea\036\uffea" +
    "\037\uffea\040\uffea\041\uffea\042\uffea\050\uffea\001\002\000" +
    "\004\024\060\001\002\000\070\002\uffe9\004\uffe9\006\uffe9" +
    "\007\uffe9\010\uffe9\011\uffe9\012\uffe9\013\uffe9\014\uffe9\016" +
    "\uffe9\023\uffe9\024\uffe9\025\uffe9\026\uffe9\027\uffe9\030\uffe9" +
    "\031\uffe9\032\uffe9\033\uffe9\034\uffe9\035\uffe9\036\uffe9\037" +
    "\uffe9\040\uffe9\041\uffe9\042\uffe9\050\uffe9\001\002\000\042" +
    "\014\062\024\ufff5\025\040\026\034\027\032\030\046\031" +
    "\043\032\036\033\047\034\042\035\033\036\037\037\044" +
    "\040\035\041\041\042\050\001\002\000\016\023\ufff4\043" +
    "\ufff4\044\ufff4\045\ufff4\046\ufff4\050\ufff4\001\002\000\006" +
    "\023\054\047\051\001\002\000\070\002\uffeb\004\uffeb\006" +
    "\uffeb\007\uffeb\010\uffeb\011\uffeb\012\uffeb\013\uffeb\014\uffeb" +
    "\016\uffeb\023\uffeb\024\uffeb\025\uffeb\026\uffeb\027\uffeb\030" +
    "\uffeb\031\uffeb\032\uffeb\033\uffeb\034\uffeb\035\uffeb\036\uffeb" +
    "\037\uffeb\040\uffeb\041\uffeb\042\uffeb\050\uffeb\001\002\000" +
    "\070\002\uffee\004\uffee\006\uffee\007\uffee\010\uffee\011\uffee" +
    "\012\uffee\013\uffee\014\uffee\016\uffee\023\uffee\024\uffee\025" +
    "\040\026\034\027\032\030\046\031\043\032\036\033\047" +
    "\034\042\035\033\036\037\037\044\040\035\041\041\042" +
    "\050\050\uffee\001\002\000\070\002\uffed\004\uffed\006\uffed" +
    "\007\uffed\010\uffed\011\uffed\012\uffed\013\uffed\014\uffed\016" +
    "\uffed\023\uffed\024\uffed\025\040\026\034\027\032\030\046" +
    "\031\043\032\036\033\047\034\042\035\033\036\037\037" +
    "\044\040\035\041\041\042\050\050\uffed\001\002\000\010" +
    "\020\053\023\054\047\051\001\002\000\016\023\027\043" +
    "\024\044\023\045\021\046\017\050\026\001\002\000\060" +
    "\002\ufffd\004\ufffd\007\ufffd\010\ufffd\011\ufffd\013\ufffd\016" +
    "\ufffd\023\ufffd\025\040\026\034\027\032\030\046\031\043" +
    "\032\036\033\047\034\042\035\033\036\037\037\044\040" +
    "\035\041\041\042\050\050\ufffd\001\002\000\026\002\uffd6" +
    "\004\uffd6\005\073\007\uffd6\010\uffd6\011\uffd6\013\uffd6\016" +
    "\uffd6\023\uffd6\050\uffd6\001\002\000\016\023\027\043\024" +
    "\044\023\045\021\046\017\050\026\001\002\000\060\002" +
    "\uffd5\004\uffd5\007\uffd5\010\uffd5\011\uffd5\013\uffd5\016\uffd5" +
    "\023\uffd5\025\040\026\034\027\032\030\046\031\043\032" +
    "\036\033\047\034\042\035\033\036\037\037\044\040\035" +
    "\041\041\042\050\050\uffd5\001\002\000\040\012\076\025" +
    "\040\026\034\027\032\030\046\031\043\032\036\033\047" +
    "\034\042\035\033\036\037\037\044\040\035\041\041\042" +
    "\050\001\002\000\020\007\ufffe\010\ufffe\011\ufffe\013\ufffe" +
    "\016\ufffe\023\ufffe\050\ufffe\001\002\000\020\007\ufff6\010" +
    "\005\011\010\013\100\016\013\023\016\050\015\001\002" +
    "\000\016\007\ufffe\010\ufffe\011\ufffe\016\ufffe\023\ufffe\050" +
    "\ufffe\001\002\000\004\007\102\001\002\000\024\002\ufff8" +
    "\004\ufff8\007\ufff8\010\ufff8\011\ufff8\013\ufff8\016\ufff8\023" +
    "\ufff8\050\ufff8\001\002\000\016\007\ufff7\010\005\011\010" +
    "\016\013\023\016\050\015\001\002\000\022\002\uffff\007" +
    "\uffff\010\uffff\011\uffff\013\uffff\016\uffff\023\uffff\050\uffff" +
    "\001\002\000\040\006\106\025\040\026\034\027\032\030" +
    "\046\031\043\032\036\033\047\034\042\035\033\036\037" +
    "\037\044\040\035\041\041\042\050\001\002\000\016\007" +
    "\ufffe\010\ufffe\011\ufffe\016\ufffe\023\ufffe\050\ufffe\001\002" +
    "\000\016\007\110\010\005\011\010\016\013\023\016\050" +
    "\015\001\002\000\024\002\ufffc\004\ufffc\007\ufffc\010\ufffc" +
    "\011\ufffc\013\ufffc\016\ufffc\023\ufffc\050\ufffc\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\106\000\004\002\003\001\001\000\012\003\005\004" +
    "\013\006\011\015\010\001\001\000\010\006\021\012\104" +
    "\014\024\001\001\000\002\001\001\000\002\001\001\000" +
    "\010\006\021\012\074\014\024\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\006\021\012\017\014\024\001\001" +
    "\000\002\001\001\000\004\013\030\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\010\006\021\012\065\014\024\001\001\000\002\001" +
    "\001\000\010\006\021\012\027\014\024\001\001\000\004" +
    "\013\030\001\001\000\010\006\021\012\064\014\024\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\007\051\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\010" +
    "\056\011\054\001\001\000\010\006\021\012\060\014\024" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\013\030\001\001\000\002\001\001\000\004" +
    "\007\063\001\001\000\002\001\001\000\004\013\030\001" +
    "\001\000\004\013\030\001\001\000\004\007\051\001\001" +
    "\000\010\006\021\012\070\014\024\001\001\000\004\013" +
    "\030\001\001\000\002\001\001\000\010\006\021\012\073" +
    "\014\024\001\001\000\004\013\030\001\001\000\004\013" +
    "\030\001\001\000\004\002\076\001\001\000\014\003\005" +
    "\004\013\005\100\006\011\015\010\001\001\000\004\002" +
    "\102\001\001\000\002\001\001\000\002\001\001\000\012" +
    "\003\005\004\013\006\011\015\010\001\001\000\002\001" +
    "\001\000\004\013\030\001\001\000\004\002\106\001\001" +
    "\000\012\003\005\004\013\006\011\015\010\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= bloco EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Bloco start_val = (Bloco)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // bloco ::= bloco comando 
            {
              Bloco RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Bloco b = (Bloco)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Comando c = (Comando)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Bloco(b,c); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bloco",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // bloco ::= bloco comando SEMICOLON 
            {
              Bloco RESULT =null;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Bloco b = (Bloco)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Comando c = (Comando)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new Bloco(b,c); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("bloco",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // bloco ::= 
            {
              Bloco RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("bloco",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // comando ::= IDENTIFIER ASSIGN_OP exp 
            {
              Comando RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		java.lang.String id = (java.lang.String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Comando(id, e);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("comando",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // comando ::= WHILE exp DO_KWORD bloco END_KWORD 
            {
              Comando RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Bloco b = (Bloco)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new Comando(e,b); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("comando",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // comando ::= ifstat 
            {
              Comando RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("comando",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // comando ::= chamadadefuncao 
            {
              Comando RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("comando",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // comando ::= declaracaovariavel 
            {
              Comando RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("comando",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // ifstat ::= IF_KWORD exp THEN_KWORD bloco elsestat END_KWORD 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("ifstat",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // elsestat ::= ELSE_KWORD bloco 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("elsestat",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // elsestat ::= 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("elsestat",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // listaexp ::= listaexpaux exp 
            {
              Exp RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("listaexp",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // listaexpaux ::= listaexpaux exp COMA 
            {
              Exp RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("listaexpaux",7, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // listaexpaux ::= 
            {
              Exp RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("listaexpaux",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // exp ::= NUMBER 
            {
              Exp RESULT =null;
		int n1left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int n1right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		java.lang.Number n1 = (java.lang.Number)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Exp(n1);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // exp ::= IDENTIFIER 
            {
              Exp RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		java.lang.String id = (java.lang.String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT =  new Exp(id); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // exp ::= chamadadefuncao 
            {
              Exp RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",8, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // exp ::= LPAREN exp RPAREN 
            {
              Exp RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // exp ::= exp opbin exp 
            {
              Exp RESULT =null;
		 System.out.println("Operacao");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // exp ::= opunaria exp 
            {
              Exp RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("exp",8, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // chamadadefuncao ::= LPAREN exp RPAREN args 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("chamadadefuncao",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // chamadadefuncao ::= LPAREN exp RPAREN COLON IDENTIFIER args 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("chamadadefuncao",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // args ::= LPAREN RPAREN 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("args",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // args ::= LPAREN listaexp RPAREN 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("args",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // args ::= STRING 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("args",5, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // opbin ::= PLUS_OP 
            {
              Object RESULT =null;
		 System.out.println("+");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // opbin ::= MINUS_OP 
            {
              Object RESULT =null;
		 System.out.println("-");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // opbin ::= TIMES_OP 
            {
              Object RESULT =null;
		 System.out.println("*");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // opbin ::= SLASH_OP 
            {
              Object RESULT =null;
		 System.out.println("/");
              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // opbin ::= POT_OP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // opbin ::= PERCENT_OP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // opbin ::= LESS_OP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // opbin ::= LESSEQUALS_OP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // opbin ::= MORE_OP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // opbin ::= MOREEQUALS_OP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // opbin ::= EQUALS_OP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // opbin ::= DIFFERENT_OP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // opbin ::= AND_KWORD 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // opbin ::= OR_KWORD 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opbin",9, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // opunaria ::= MINUS_UNOP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opunaria",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // opunaria ::= NOT_KWORD 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opunaria",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // opunaria ::= HASH_OP 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("opunaria",10, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // declaracaovariavel ::= VAR_KWORD IDENTIFIER 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("declaracaovariavel",11, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // declaracaovariavel ::= VAR_KWORD IDENTIFIER ASSIGN_OP exp 
            {
              Object RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("declaracaovariavel",11, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
