package com.chen;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

public class PluginDemoAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        String userName = askForName(project);
        sayHello(project, userName);
    }

    private String askForName(Project project) {
        return Messages.showInputDialog(project,
                "What is your name?", "Input Your Name",
                Messages.getQuestionIcon());
    }

    private void sayHello(Project project, String userName) {
        Messages.showMessageDialog(project,
                String.format("Hello, %s!\n Welcome to MyPlugin.", userName), "Information",
                Messages.getInformationIcon());
    }
}