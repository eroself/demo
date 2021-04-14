package com.wontlost;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.PWA;
import com.wontlost.alert.SweetAlert2View;
import com.wontlost.ckeditor.views.CKEditorView;
import com.wontlost.datebook.DatebookView;
import com.wontlost.dicebear.DicebearView;
import com.wontlost.zxing.ZXingView;

import static com.wontlost.ckeditor.utils.Constant.*;

/**
 * @author Ryan Pang
 * @date 4/14/2021
 */
@Route("demo")
@RouteAlias(PAGE_ROOT)
@PWA(name = "Demo", shortName = "Demo", display = "fullscreen")
public class DemoView extends VerticalLayout implements HasUrlParameter<String> {

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        if (parameter == null) {
            createDemoPage();
        } else if (parameter.equals("ckeditor")) {
            add(new CKEditorView());
        } else if (parameter.equals("zxing")) {
            add(new ZXingView());
        } else if (parameter.equals("dicebear")) {
            add(new DicebearView());
        } else if (parameter.equals("datebook")) {
            add(new DatebookView());
        } else if (parameter.equals("alert")) {
            add(new SweetAlert2View());
        }
        setAlignItems(Alignment.CENTER);
    }

    public void createDemoPage() {
        FormLayout layout = new FormLayout();
        Image ckeditor = new Image();
        Image zxing = new Image();
        Image dicebear = new Image();
        Image alert = new Image();
        Image datebook = new Image();

        ckeditor.setHeight(200, Unit.PIXELS);
        ckeditor.setWidth(200, Unit.PIXELS);
        ckeditor.setSrc("icons/ckeditor.png");
        zxing.setHeight(200, Unit.PIXELS);
        zxing.setWidth(200, Unit.PIXELS);
        zxing.setSrc("icons/zxing.png");
        dicebear.setHeight(200, Unit.PIXELS);
        dicebear.setWidth(200, Unit.PIXELS);
        dicebear.setSrc("icons/dicebear.png");
        alert.setHeight(200, Unit.PIXELS);
        alert.setWidth(200, Unit.PIXELS);
        alert.setSrc("icons/sweetAlert.png");
        datebook.setHeight(200, Unit.PIXELS);
        datebook.setWidth(200, Unit.PIXELS);
        datebook.setSrc("icons/datebook.png");

        ckeditor.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(PAGE_DEMO_CKEDITOR)));
        zxing.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(PAGE_DEMO_ZXING)));
        dicebear.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(PAGE_DEMO_DICEBEAR)));
        alert.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(PAGE_DEMO_ALERT)));
        datebook.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(PAGE_DEMO_DATEBOOK)));

        layout.add(ckeditor, zxing, dicebear, alert, datebook);
        add(layout);
    }

}
