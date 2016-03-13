
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import mockTests.*;

/**
 * A Test Suite for testing database mocking classes.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Run {
  public static void main(String args[]) {
    System.out.println("***RUN SPEC***");

    System.out.println("*RUNNING DATABASE TEST SPEC*");
        // System.out.println("*RUNNING TABLE TEST SPEC*");


    Result result = JUnitCore.runClasses(DatabaseTest.class);

    for (Failure failure : result.getFailures()) {
      System.out.println("FAIL: " + failure.toString());
    }
    System.out.println(result.wasSuccessful());


  }
}
