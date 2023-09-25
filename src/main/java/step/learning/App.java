package step.learning;

import step.learning.basics.BasicsDemo;
import step.learning.files.DirDemo;
import step.learning.files.FileIoDemo;
import step.learning.files.FilesHW;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//new DirDemo().run();
//        new FileIoDemo().run();
        FilesHW fw = new FilesHW("./");

        fw.Run();
    }

}
