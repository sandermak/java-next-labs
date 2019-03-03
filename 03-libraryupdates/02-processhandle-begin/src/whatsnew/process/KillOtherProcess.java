package whatsnew.process;

public class KillOtherProcess {

    public static void main(String... args) throws Exception {

      ProcessHandle applicationHandle =
          null; // Obtain the process you want to kill by inspecting all processes and finding the right one.


      System.out.println(applicationHandle.info());
    }

}
