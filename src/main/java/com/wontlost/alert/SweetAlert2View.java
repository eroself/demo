package com.wontlost.alert;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.wontlost.sweetalert2.Config;
import com.wontlost.sweetalert2.SweetAlert2Vaadin;

/**
 * @author Ryan Pang
 * @date 4/15/2021
 */
public class SweetAlert2View extends VerticalLayout {

    public SweetAlert2View(){
        Button openAlert = new Button("Open Alert");
        openAlert.addClickListener(buttonClickEvent -> {
            Config config = new Config();
            config.setTitle("Error!!!");
            config.setText("Something went wrong.");
            config.setIcon("error");
            config.setShowCancelButton(true);
            config.setShowCloseButton(true);
            config.setFooter("<a href>Why do I have this issue?</a>");
            SweetAlert2Vaadin sweetAlert2Vaadin = new SweetAlert2Vaadin(config);
            sweetAlert2Vaadin.open();
            sweetAlert2Vaadin.addConfirmListener(e->{
                Notification.show("Confirmed!");
                System.out.println("confirm result : "+e.getSource().getSweetAlert2Result());
            });
            sweetAlert2Vaadin.addCancelListener(e->{
                Notification.show("Cancelled!");
                System.out.println("cancel result : "+e.getSource().getSweetAlert2Result());
            });
            sweetAlert2Vaadin.addCloseListener(e->{
                Notification.show("Closed!");
                System.out.println("close result : "+e.getSource().getSweetAlert2Result());
            });
            sweetAlert2Vaadin.addDenyListener(e->{
                Notification.show("Denied!");
                System.out.println("deny result : "+e.getSource().getSweetAlert2Result());
            });
        });

        add(openAlert);
        setAlignItems(FlexComponent.Alignment.CENTER);
    }

}
