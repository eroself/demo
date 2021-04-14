package com.wontlost.ckeditor.views.dialog;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.wontlost.ckeditor.Config;
import com.wontlost.ckeditor.Constants.EditorType;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;
import com.wontlost.ckeditor.views.CKEditorView;

import static com.wontlost.ckeditor.utils.Constant.PAGE_DIALOG_EDITOR;
import static com.wontlost.ckeditor.utils.Constant.TITLE_DIALOG_EDITOR;

@Route(value = PAGE_DIALOG_EDITOR, layout = CKEditorView.class)
@PageTitle(TITLE_DIALOG_EDITOR)
public class DialogView extends VerticalLayout {



    public DialogView() {
        super();
        VerticalLayout verticalLayout = new VerticalLayout();
        Button openInDialog = new Button("Open in dialog");
        Button cancel = new Button("Cancel");
        Dialog dialog = new Dialog();
        VaadinCKEditor editor = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = "<p>This is a editor within dialog example.</p>";
            builder.editorType = EditorType.CLASSIC;
        }).createVaadinCKEditor();
        Config config = new Config();
        config.setImage(new String[][]{},
                "", new String[]{"full", "alignLeft", "alignCenter", "alignRight"},
                new String[]{"imageTextAlternative", "|",
                        "imageStyle:alignLeft",
                        "imageStyle:full",
                        "imageStyle:alignCenter",
                        "imageStyle:alignRight"}, new String[]{});
        editor.setConfig(config);
        openInDialog.addClickListener((event -> {
            dialog.setModal(false);
            dialog.setDraggable(true);
            dialog.setResizable(true);
            verticalLayout.add(editor, cancel);
            verticalLayout.setAlignItems(Alignment.CENTER);
            dialog.add(verticalLayout);
            dialog.open();
        }));

        cancel.addClickListener(event -> dialog.close());

        add(openInDialog);

        setAlignItems(Alignment.CENTER);
    }

}
