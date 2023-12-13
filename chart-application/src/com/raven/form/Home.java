package com.raven.form;

import com.raven.model.Model_User_Account;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class Home extends javax.swing.JLayeredPane {

    private Chat chat;
    private Menu_Center menuCenter;
    private Menu_Right menuRight;
    
    private boolean menuRightAdded = false;

    public Home() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx, filly", "0[200!]5[fill, 100%]5[200!]0", "0[fill]0"));
        this.add(new Menu_Left());
        menuCenter = new Menu_Center(); // Create an instance of Menu_Center
        this.add(menuCenter);
        
        chat = new Chat();
        this.add(chat);
        chat.setVisible(false);
        
        menuRight = new Menu_Right();
    }

    public void setUser(Model_User_Account user) {
        chat.setUser(user);
        chat.setVisible(true);
        
        menuRight.setVisible(true);
        
        // Remove Menu_Center after chat is visible
        remove(menuCenter);
        // Add menuRight only when chat is visible and it has not been added before
        if (chat.isVisible() && !menuRightAdded) {
            this.add(menuRight);
            menuRightAdded = true; // Set the flag to true after adding menuRight
        }
        revalidate();
        repaint();
        
    }

    public void updateUser(Model_User_Account user) {
        chat.updateUser(user);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1106, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
