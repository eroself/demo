package com.wontlost.zxing;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import static com.wontlost.ckeditor.utils.Constant.PAGE_DEMO_ZXING;

/**
 * The main view is a top-level placeholder for other views.
 */
@JsModule("./styles/shared-styles.js")
@Route(value = PAGE_DEMO_ZXING)
@PageTitle("ZXing")
public class ZXingView extends VerticalLayout {

    public ZXingView() {
        super();
        NativeLabel value1 = new NativeLabel();
        NativeLabel value2 = new NativeLabel();
        ZXingVaadinReader zXingVaadin1 = new ZXingVaadinReader();
        zXingVaadin1.setFrom(Constants.From.camera);
        zXingVaadin1.setWidth("300");
        zXingVaadin1.setHeight("300");
        zXingVaadin1.setStyle("border : 1px solid gray; object-fit: none;");
        zXingVaadin1.addValueChangeListener(e->{
            System.out.println("====================================================");
            System.out.println("=================QR=====:"+e.getValue());
            System.out.println("====================================================");
            value1.setText(e.getValue());
            //remove(zXingVaadin1);
        });
        add(zXingVaadin1);

        ZXingVaadinReader zXingVaadin2 = new ZXingVaadinReader();
        zXingVaadin2.setFrom(Constants.From.camera);
        zXingVaadin2.setWidth("300");
        zXingVaadin2.setHeight("300");
        zXingVaadin2.setStyle("border : 1px solid gray; object-fit: none;");
        zXingVaadin2.addValueChangeListener(e->{
            System.out.println("====================================================");
            System.out.println("=================QR=====:"+e.getValue());
            System.out.println("====================================================");
            value2.setText(e.getValue());
        });
        add(zXingVaadin2);

        add(new NativeLabel(""));
        Button reset = new Button("Reset");
        reset.addClickListener(event -> {
            zXingVaadin1.reset();
            zXingVaadin2.reset();
            value1.setText("");
            value2.setText("");
        });

        add(reset);
        add(value1);
        add(value2);
        setAlignItems(Alignment.CENTER);
    }

}
