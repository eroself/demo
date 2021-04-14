package com.wontlost.ckeditor.views.balloon;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.wontlost.ckeditor.Config;
import com.wontlost.ckeditor.Constants.*;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;
import com.wontlost.ckeditor.views.CKEditorView;

import static com.wontlost.ckeditor.utils.Constant.*;

@Route(value = PAGE_BALLOON_EDITOR, layout = CKEditorView.class)
@PageTitle(TITLE_BALLOON_EDITOR)
public class BalloonView extends VerticalLayout {

    public BalloonView() {
        super();
        Config config = new Config();
        config.setBalloonToolBar(Toolbar.values());
        config.setImage(new String[][]{},
                "", new String[]{"full", "alignLeft", "alignCenter", "alignRight"},
                new String[]{"imageTextAlternative", "|",
                        "imageStyle:alignLeft",
                        "imageStyle:full",
                        "imageStyle:alignCenter",
                        "imageStyle:alignRight"}, new String[]{});
        VaadinCKEditor editor = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = "<p>This is a balloon editor example.</p>";
            builder.editorType = EditorType.BALLOON;
            builder.config = config;
        }).createVaadinCKEditor();
        add(editor);

        add(new Label("--------------Preview---------------"));
        Label label = new Label();
        label.getElement().setProperty("innerHTML", editor.getValue());
        editor.addValueChangeListener(e-> label.getElement().setProperty("innerHTML", e.getValue()));
        add(label);
        add(new Label("--------------Preview---------------"));

        setAlignItems(Alignment.CENTER);

    }

}
