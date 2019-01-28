package abcpack;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
//import org.junit.Test;
import org.junit.rules.TestName;

public class D {
	  @Rule
	  public TestName name= new TestName();
	  
      @DisplayName("get test method")
	  @Test
	  public void testA(TestInfo info) {
	      //assertEquals("testA", name.getMethodName());
		  System.out.println(info.getDisplayName());
	     }
}
