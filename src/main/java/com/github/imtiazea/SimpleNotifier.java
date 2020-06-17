package com.github.imtiazea;

import java.awt.*;

public class SimpleNotifier {

    public SimpleNotifier() {
        System.setProperty("java.awt.headless", "false");
    }

    public void pushNotification(String notificationCaption, String notificationText, TrayIcon.MessageType messageType) {

        SystemTray tray = SystemTray.getSystemTray();

        String imagePath = "";

        Image image = Toolkit.getDefaultToolkit().createImage(imagePath);
        TrayIcon trayIcon = new TrayIcon(image, "Simple Notification");

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        trayIcon.displayMessage(notificationCaption, notificationText, messageType);

        tray.remove(trayIcon);
    }

//    public static void main(String[] args) {
//        SimpleNotifier simpleNotifier =  new SimpleNotifier();
//
//        String successMessage = "Upload Successful!";
//        String successDetailsMessage = "Link copied to clipboard";
//        TrayIcon.MessageType successMessageType = TrayIcon.MessageType.INFO;
//
//        simpleNotifier.pushNotification(successMessage, successDetailsMessage, successMessageType);
//
//    }
}