package com.vf.apex.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IStorageEditorInput;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;

public class RichVisualForceEditor extends TextEditor {

	private ColorManager colorManager;

	public RichVisualForceEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}
	
	private IDocumentProvider createDocumentProvider(IEditorInput input) {
		if(input instanceof IFileEditorInput){
			return new XMLTextProvider();
		} else if(input instanceof IStorageEditorInput){
			return new XMLDocumentProvider();
		} else {
			return new XMLTextProvider();
		}
	}
	
	@Override
	protected final void doSetInput(IEditorInput input) throws CoreException {
		setDocumentProvider(createDocumentProvider(input));
		super.doSetInput(input);
	}

}
