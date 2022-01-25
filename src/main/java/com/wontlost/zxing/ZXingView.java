package com.wontlost.zxing;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import static com.wontlost.ckeditor.utils.Constant.PAGE_DEMO_ZXING;

/**
 * The main view is a top-level placeholder for other views.
 */
@JsModule("./styles/shared-styles.js")
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
@Route(value = PAGE_DEMO_ZXING)
@PageTitle("ZXing")
public class ZXingView extends VerticalLayout {

    public ZXingView() {
        super();
        Label value1 = new Label();
        ZXingVaadinReader zXingVaadin1 = new ZXingVaadinReader();
        zXingVaadin1.setFrom(Constants.From.camera);
//        zXingVaadin1.setId("video");
        zXingVaadin1.setWidth("350");
        zXingVaadin1.setStyle("border : 1px solid gray");
        zXingVaadin1.addValueChangeListener(e->{
            System.out.println("====================================================");
            System.out.println("=================QR=====:"+e.getValue());
            System.out.println("====================================================");
            value1.setText(e.getValue());
        });
        add(zXingVaadin1);
        add(new Label(""));
        Button reset = new Button("Reset");
        reset.addClickListener(event -> {
            zXingVaadin1.reset();
            value1.setText("");
        });
        add(reset);
        add(value1);
        setAlignItems(Alignment.CENTER);
    }

}
