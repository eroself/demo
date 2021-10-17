package com.wontlost.ckeditor.views.classic;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.wontlost.ckeditor.Config;
import com.wontlost.ckeditor.Constants.EditorType;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;
import com.wontlost.ckeditor.views.CKEditorView;

import static com.wontlost.ckeditor.utils.Constant.*;

@Route(value = PAGE_CLASSIC_EDITOR, layout = CKEditorView.class)
@RouteAlias(value = PAGE_DEMO_CKEDITOR, layout = CKEditorView.class)
@PageTitle(TITLE_CLASSIC_EDITOR)
public class ClassicView extends VerticalLayout {

    public ClassicView() {
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
            builder.editorData = "<p>This is a classic editor example.</p>";
            builder.editorType = EditorType.CLASSIC;
            builder.width = "70%";
            builder.config = config;
        }).createVaadinCKEditor();
        add(editor);

//        Button openInDialog = new Button("Open in dialog");
//        openInDialog.addClickListener((event -> {
//            Dialog dialog = new Dialog();
//            dialog.setModal(false);
//            dialog.setCloseOnOutsideClick(false);
//            dialog.setResizable(true);
//            dialog.add(editor);
//            dialog.open();
//        }));
//        add(editor, openInDialog);

        add(new Label("--------------Preview---------------"));
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
//        Label label = new Label();
//        label.setWidth(editor.getWidth());
//        label.getElement().setProperty("innerHTML", editor.getValue());
//        editor.addValueChangeListener(e-> label.getElement().setProperty("innerHTML", e.getValue()));
//        add(label);
        add(new Label("--------------Preview---------------"));

        setAlignItems(Alignment.CENTER);
    }

}
