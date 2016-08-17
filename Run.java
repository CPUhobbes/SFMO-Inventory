
/**
 * Write a description of class Run here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Run
{
    // instance variables - replace the example below with your own
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        GraphicInterface g = new GraphicInterface();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                g.createAndShowGUI();
            }
        });
    }
}
