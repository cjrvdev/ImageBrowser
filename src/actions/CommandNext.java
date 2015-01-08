package actions;

import view.ImageViewer;

public class CommandNext extends Command{
    private final ImageViewer viewer;

    public CommandNext(ImageViewer viewer){
        this.viewer = viewer;
    }
    
    @Override
    public void execute() {
        System.out.println(viewer);
        System.out.println(viewer.getImage().getNext());
        viewer.setImage(viewer.getImage().getNext());
    }
    
}
