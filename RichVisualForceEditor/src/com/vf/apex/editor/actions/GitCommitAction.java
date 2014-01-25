package com.vf.apex.editor.actions;

import java.io.File;
import java.text.DateFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.vf.apex.Activator;
import com.vf.apex.editor.helper.Helper;


public class GitCommitAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	/**
	 * The constructor.
	 */
	public GitCommitAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		//System.out.println("action.getText---" + action.getText());
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		Git git = null;
		try {
			for (IProject iProject : projects) {
				if(iProject.isOpen()){
					String absolutePath = iProject.getLocation().toFile().getAbsolutePath();
					String projectName = absolutePath.substring(absolutePath.lastIndexOf(File.separator)+1);
					Boolean isCommitEnable = Activator.getDefault().getPreferenceStore().getBoolean("COMMIT_ENABLE_"+projectName);
					String repoPath = Activator.getDefault().getPreferenceStore().getString("REPOSITORY_"+projectName);

					git = Git.open(new File(repoPath + "/.git"));
					Repository repository = git.getRepository();

					String head = repository.getFullBranch();
					if (head!=null && head.startsWith("refs/heads/")) {
						if(isCommitEnable){
							Helper.copyDirectory(iProject.getLocation().toFile(), new File(repoPath));
							//System.out.println("copying files ........ ");
							git.add().addFilepattern(".").call();
							git.commit().setMessage("Auto commit via Rich Visualforce plugin " + DateFormat.getInstance().format(System.currentTimeMillis())).call();
						}
					}else{
						MessageDialog.openError(window.getShell() , "Project Git Repository is not a valid repository", 
								"Project Git Repository is not a valid repository. \n ProjectName: " + projectName + "\n Path: " + repoPath);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//System.out.println("closing git repo.. ");
		}

	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}