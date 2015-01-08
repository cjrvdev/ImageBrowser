package app;

import actions.Command;
import actions.CommandNext;
import actions.CommandPrev;
import model.Image;
import persistence.ImageDirectoryLoad;
import swing.ActionListenerCreator;
import swing.MainFrame;
import view.ImageViewer;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

    Recibida ayuda por el alumno Juan David Vega Rodríguez.

*/
public class Application {

    private static final String PATH = "C:\\Users\\Tronx\\Pictures";

    public static void main(String[] args) {
        new Application().excute();
    }

    private void excute() {
        List<Image> images = new ImageDirectoryLoad(PATH).load(); 
        MainFrame main = new MainFrame(new ActionListenerCreator() {
            @Override
            public ActionListener create(int buttonId, ImageViewer viewer) {
                return loadCommandSet(viewer).get(buttonId);
            }

            private Map<Integer, Command> loadCommandSet(ImageViewer viewer) {
               Map<Integer, Command> commandSet = new HashMap<>();
               commandSet.put(MainFrame.NEXT, new CommandNext(viewer));
               commandSet.put(MainFrame.PREV, new CommandPrev(viewer));
               return commandSet;
            }
        });
        main.setImage(images.get(0));
    }

    

    private ActionListener[] getListners(ImageViewer viewer) {
        ActionListener[] listeners =  new ActionListener[2];
        listeners[MainFrame.NEXT] = new CommandNext(viewer);
        listeners[MainFrame.PREV] = new CommandPrev(viewer);
        return listeners;
    
    }
}
