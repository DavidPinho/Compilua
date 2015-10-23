package tree;
public interface Op {
	public final static int	PLUS_OP = 0;
	public final static int MINUS_OP = 1;
	public final static int  TIMES_OP = 2;
	public final static int  SLASH_OP = 3;
	public final static int  POT_OP = 4;
	public final static int  PERCENT_OP = 5;
	public final static int  TWODOTS = 6;
	public final static int  LESS_OP = 7;
	public final static int  LESSEQUALS_OP = 8;
	public final static int  MORE_OP = 9;
	public final static int  MOREEQUALS_OP = 10;
	public final static int  EQUALS_OP = 11;
	public final static int  DIFFERENT_OP = 12;
	public final static int  AND_KWORD = 13;
	public final static int  OR_KWORD = 14;
}