package net.weever.zebra.dao;

import net.weever.zebra.model.Notification;

import java.util.List;

public interface NotificationDao < T extends Notification>{

    public void insert(T notification);
    public void delete(T notification);
    public List< T > findByReceiver(String receiver, int limit);
    public T findNoticiation(String receiver, String nid);
}
