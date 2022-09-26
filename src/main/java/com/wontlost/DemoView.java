package com.wontlost;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.wontlost.alert.SweetAlert2View;
import com.wontlost.anime.AnimeView;
import com.wontlost.ckeditor.views.CKEditorView;
import com.wontlost.datebook.DatebookView;
import com.wontlost.dicebear.DicebearView;
import com.wontlost.zxing.ZXingView;

import java.util.HashMap;
import java.util.Map;

import static com.wontlost.ckeditor.utils.Constant.*;

/**
 * @author Ryan Pang
 * @date 4/14/2021
 */
@Route("demo")
@RouteAlias(PAGE_ROOT)
public class DemoView extends VerticalLayout implements HasUrlParameter<String> {

    private static final Map<String, Component> components = new HashMap<>();

    DemoView() {
        components.put("ckeditor", new CKEditorView());
        components.put("zxing", new ZXingView());
        components.put("dicebear", new DicebearView());
        components.put("datebook", new DatebookView());
        components.put("cron", new AnimeView());
        components.put("alert", new SweetAlert2View());
        components.put("", createDemoPage());
        components.put(null, createDemoPage());
        components.put("undefined", createDemoPage());
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        add(components.get(parameter));
        setAlignItems(Alignment.CENTER);
    }

    public FormLayout createDemoPage() {
        FormLayout layout = new FormLayout();
        Image ckeditor = new Image();
        Image zxing = new Image();
        Image dicebear = new Image();
        Image alert = new Image();
        Image datebook = new Image();

        ckeditor.setMaxHeight("200px");
        ckeditor.setMaxWidth("200px");
        ckeditor.setTitle("CKEditor");
        ckeditor.getStyle().set("padding", "22px");
        ckeditor.getStyle().set("cursor", "pointer");
        ckeditor.setSrc("icons/ckeditor.png");
        zxing.setMaxHeight("200px");
        zxing.setMaxWidth("200px");
        zxing.setTitle("ZXing");
        zxing.getStyle().set("padding", "22px");
        zxing.getStyle().set("cursor", "pointer");
        zxing.setSrc("icons/zxing.png");
        dicebear.setMaxHeight("200px");
        dicebear.setMaxWidth("200px");
        dicebear.setTitle("Dicebear");
        dicebear.getStyle().set("padding", "22px");
        dicebear.getStyle().set("cursor", "pointer");
        dicebear.setSrc("icons/dicebear.png");
        alert.setMaxHeight("200px");
        alert.setMaxWidth("200px");
        alert.setTitle("SweetAlert2");
        alert.getStyle().set("padding", "22px");
        alert.getStyle().set("cursor", "pointer");
        alert.setSrc("icons/sweetAlert.png");
        datebook.setMaxHeight("200px");
        datebook.setMaxWidth("200px");
        datebook.setTitle("Datebook");
        datebook.getStyle().set("padding", "22px");
        datebook.getStyle().set("cursor", "pointer");
        datebook.setSrc("icons/datebook.png");

        addClickListener(ckeditor, PAGE_DEMO_CKEDITOR);
        addClickListener(zxing, PAGE_DEMO_ZXING);
        addClickListener(dicebear, PAGE_DEMO_DICEBEAR);
        addClickListener(alert, PAGE_DEMO_ALERT);
        addClickListener(datebook, PAGE_DEMO_DATEBOOK);
        //ckeditor.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(PAGE_DEMO_CKEDITOR)));
        //zxing.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(PAGE_DEMO_ZXING)));
        //dicebear.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(PAGE_DEMO_DICEBEAR)));
        //alert.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(PAGE_DEMO_ALERT)));
        //datebook.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(PAGE_DEMO_DATEBOOK)));

        layout.add(ckeditor, zxing, dicebear, alert, datebook);
        return layout;
    }

    private void addClickListener(Image image, String page) {
        image.addClickListener(e-> this.getUI().ifPresent(ui -> ui.navigate(page)));
    }

}
