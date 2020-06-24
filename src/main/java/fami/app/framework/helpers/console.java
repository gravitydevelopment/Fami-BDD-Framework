package fami.app.framework.helpers;

//import com.experian.dadtf.helpers.testLogger;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * console.java - Console classes consist a method to access and execute a command from the
 * command line interface.
 *
 * @author   Fami Romli, https://github.com/gravitydevelopment/Fami-BDD-Framework
 * @version  1.0
 * @since    20 June 2020
 */

public class console {

  static List<String> list = new ArrayList<String>();
  static String srcDir;

  //private static final testLogger log = testLogger.getLogger("com.experian.automation.dadtf.lite.helpers.console");

  /**
   * This method is to execute a cmd executable files
   */
  public static void executeCLI(String srcPath, String command) {

    //log.debug("Source Path: "+srcPath);

    list.clear();
    list.add("cmd.exe");
    list.add("/C");
    list.add(command);
    list.add("exit");

    intCommand(list);
    //log.debug("Command: " + list + "executed.");

  }

  /**
   * This method is to execute a .jar, .bash and .exe executable files
   */
  public static void executableFile(String srcPath, String ext, String fileName, String args) {

    srcDir = srcPath;
    //log.debug("Source Path: "+srcPath);

    if (ext.equals("jar")) {
      list.clear();
      list.add("java");
      list.add("-jar");
      list.add(fileName);
      if (args != null) {
        list.add(args);
      }

    } else if (ext.equals("bat")) {
      list.clear();
      list.add("bash");
      list.add(fileName);

      if (args != null) {
        list.add(args);
      }


    } else if (ext.equals("exe")) {
      list.clear();
      list.add("cmd.exe");
      list.add("/C");
      list.add(fileName);
      if (args != null) {
        list.add(args);
      }
    }
    intCommand(list);
    //log.debug("Command: " + list + "executed.");

  }

  /**
   * This method is to execute the command in CLI
   */
  private static void intCommand(List command) {

    ProcessBuilder build = new ProcessBuilder(command);
    build.directory(new File(srcDir));

    try {
      Process process = build.start();
      BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String s = null;

      //log.debug("Command list: " + build.command());

      while ((s = stdInput.readLine()) != null) {
        //log.debug("Output: " + s);
      }

    } catch (IOException e) {
      //log.error("Console execution fail due to : ");
      e.printStackTrace();
    }

  }

}
