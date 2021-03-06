package ch.heigvd.res.lab01.impl;

import java.util.LinkedList;
import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines)
  {
    String rtn[] = new String[2];

    // parce the string and detect the /n or /r
    for (int i = 0; i < lines.length(); ++i)
    {
      if (lines.charAt(i) == '\r')
      {

        if (lines.length() > i+1 && lines.charAt(i+1) == '\n')
        {
          rtn[0] = lines.substring(0, i+2);
          rtn[1] = lines.substring(i+2);
          return rtn;
        }
        else
        {
          rtn[0] = lines.substring(0, i+1);
          rtn[1] = lines.substring(i+1);
          return rtn;
        }

      }

      if (lines.charAt(i) == '\n')
      {
        rtn[0] = lines.substring(0,i+1);
        rtn[1] = lines.substring(i+1);
        return rtn;
      }
    }

    // If it's empty
    rtn[0] = "";
    rtn[1] = lines;
    return rtn;
  }

}
