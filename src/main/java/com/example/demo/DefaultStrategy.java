package com.example.demo;

class DefaultStrategy implements NotificationStrategy {
    @Override
    public void executeNotification(NotificationEvent event) {
        System.out.println("Default Strategy: Notification from " +
                event.getAgentName() + " about " + event.getTransaction());
    }
}
