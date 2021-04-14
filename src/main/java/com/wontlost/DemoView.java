package com.wontlost;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.*;
import com.wontlost.ckeditor.views.CKEditorView;
import com.wontlost.dicebear.DicebearView;
import com.wontlost.zxing.ZXingView;

import static com.wontlost.ckeditor.utils.Constant.PAGE_ROOT;

/**
 * @author Ryan Pang
 * @date 4/14/2021
 */
@Route("demo")
@RouteAlias(PAGE_ROOT)
public class DemoView extends Div implements HasUrlParameter<String> {

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        if (parameter == null) {
            add(new Label("No demo specified!"));
        } else if (parameter.equals("ckeditor")) {
            add(new CKEditorView());
        } else if (parameter.equals("zxing")) {
            add(new ZXingView());
        } else if (parameter.equals("dicebear")) {
            add(new DicebearView());
        }
    }

}
