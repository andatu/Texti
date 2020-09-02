package model;

// java undo and redo action classes

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

public class UndoHandler implements UndoableEditListener {
    // undo and redo

    UndoManager undoManager = new UndoManager();
    private static UndoAction undoAction = new UndoAction();
    private static RedoAction redoAction = new RedoAction();

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());
        undoAction.update();
        redoAction.update();
    }

    /**
     * Messaged when the Document has created an edit, the edit is added to
     * <code>undoManager</code>, an instance of UndoManager.
     */


    static class UndoAction extends AbstractAction {
        public UndoAction() {
            super("Undo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if (action.equals("Undo")) {

                try {
                    UndoManager undoManager;
                    undoManager = new UndoManager();
                    undoManager.undo();
                } catch (CannotUndoException ex) {

                    ex.printStackTrace();
                }
                update();
                redoAction.update();
            }
        }

        void update() {
            UndoManager undoManager;
            undoManager = new UndoManager();

            if (undoManager.canUndo()) {
                setEnabled(true);
                putValue(Action.NAME, undoManager.getUndoPresentationName());
            } else {

                setEnabled(false);
                putValue(Action.NAME, "Undo");
            }
        }
    }

    static class RedoAction extends AbstractAction {
        UndoManager undoManager = new UndoManager();


        RedoAction() {
            super("Redo");
            setEnabled(false);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                undoManager.redo();
            } catch (CannotRedoException ex) {
                System.out.println("Unable to undo: " + ex);
                ex.printStackTrace();
            }
            update();
            undoAction.update();
        }

        void update() {
            if (undoManager.canRedo()) {
                setEnabled(true);
                putValue(Action.NAME, undoManager.getRedoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Redo");
            }
        }

    }
}