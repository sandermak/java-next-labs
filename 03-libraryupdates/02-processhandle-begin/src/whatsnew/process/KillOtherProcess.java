package whatsnew.process;

public class KillOtherProcess {

    public static void main(String... args) throws Exception {

      ProcessHandle textEditHandle =
          null; // Obtain the process you want to kill by inspecting all processes and finding the right one.


      System.out.println(textEditHandle.info());
    }

}
