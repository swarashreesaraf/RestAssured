package JavaPrograms;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class SplitPreserveTokensTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
     
    String [] tokens = StringUtils.splitPreserveAllTokens(null);
    System.out.println(Arrays.toString(tokens));
    
    tokens = StringUtils.splitPreserveAllTokens("");
    System.out.println(Arrays.toString(tokens));
    
    tokens = StringUtils.splitPreserveAllTokens("be the coder");
    System.out.println(Arrays.toString(tokens));
    
    tokens = StringUtils.splitPreserveAllTokens(" java ");
    System.out.println(Arrays.toString(tokens));
    
    tokens = StringUtils.splitPreserveAllTokens(" java  tutorials");
    System.out.println(Arrays.toString(tokens));
  }

}