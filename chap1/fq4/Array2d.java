
/**
 * @author Trevor Riddle & Dr. Fenwick
 * @version 3000
 * Array2d: Stores 2d array data in a 1d array
 *          either in row-major order or 
 *          column-major order.
 */
public class Array2d extends PartialArray2d
{

    /**
     * @param numRows is number of rows.
     * @param numCols is muber of cols.
     * @param ordering defines RMO or CMO.
     */
    public Array2d(int numRows, int numCols, int ordering)
    {
	super.rows = numRows;
	super.cols = numCols;
	super.order = ordering;
	super.data = new int[numRows * numCols];
    }
    /**
     * @param numRows done
     * @param numCols done
     */
    public Array2d(int numRows, int numCols)
    {
	super.rows = numRows;
	super.cols = numCols;
	super.order = ROW_MAJOR_ORDER;
	super.data = new int[numRows * numCols];
    }
    /**
     * @param row good
     * @param col good
     * @return an int
     */
    public int getElement(int row, int col)
    {
	if (getOrder() == COLUMN_MAJOR_ORDER)
	{
	    return super.data[getRows() * col + row];
	}
	else
	{
	    return super.data[(getCols() * row) + col];
	}
    }
    /**
     * @param row good
     * @param col good
     * @param value good
     */
    public void setElement(int row, int col, int value)
    {
	if (getOrder() == COLUMN_MAJOR_ORDER)
	{
	    super.data[getRows() * col + row] = value;
	}
	else
	{
	    super.data[(getCols() * row) + col] = value; 
	}
    }
}
