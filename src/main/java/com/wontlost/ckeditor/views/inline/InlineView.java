package com.wontlost.ckeditor.views.inline;

import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.wontlost.ckeditor.Config;
import com.wontlost.ckeditor.Constants.*;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.wontlost.ckeditor.views.CKEditorView;

import static com.wontlost.ckeditor.utils.Constant.*;

@Route(value = PAGE_INLINE_EDITOR, layout = CKEditorView.class)
@PageTitle(TITLE_INLINE_EDITOR)
public class InlineView extends VerticalLayout {

    public InlineView() {
        super();
        Config config = new Config();
        config.setImage(new String[][]{},
                "", new String[]{"full", "alignLeft", "alignCenter", "alignRight"},
                new String[]{"imageTextAlternative", "|",
                        "imageStyle:alignLeft",
                        "imageStyle:full",
                        "imageStyle:alignCenter",
                        "imageStyle:alignRight"}, new String[]{});
        VaadinCKEditor editor = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = "<p>This is a inline editor example.</p>";
            builder.editorType = EditorType.INLINE;
            builder.width = "70%";
            builder.config = config;
        }).createVaadinCKEditor();
        add(editor);

        add(new NativeLabel("--------------Preview---------------"));
//        Label label = new Label();
//        label.setWidth(editor.getWidth());
//        label.getElement().setProperty("innerHTML", editor.getValue());
//        editor.addValueChangeListener(e-> label.getElement().setProperty("innerHTML", e.getValue()));
//        add(label);
        VaadinCKEditor preview = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = editor.getValue();
            builder.editorType = EditorType.BALLOON;
            builder.width = "70%";
            builder.config = new Config();
            config.setImage(new String[][]{}, "", new String[]{}, new String[]{}, new String[]{});
            builder.readOnly = true;
        }).createVaadinCKEditor();
        add(preview);
        editor.addValueChangeListener(e->preview.setValue(editor.getValue()));
        add(new NativeLabel("--------------Preview---------------"));

        setAlignItems(Alignment.CENTER);
    }

}
