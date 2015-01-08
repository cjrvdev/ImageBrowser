package actions;

import view.ImageViewer;

public class CommandPrev extends Command{
    private final ImageViewer viewer;

    public CommandPrev(ImageViewer viewer){
        this.viewer = viewer;
    }
    
    @Override
    public void execute() {
        viewer.setImage(viewer.getImage().getPrev());
    }
    
    
}
