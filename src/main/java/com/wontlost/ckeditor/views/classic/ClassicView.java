package com.wontlost.ckeditor.views.classic;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.wontlost.ckeditor.*;
import com.wontlost.ckeditor.Constants.EditorType;
import com.wontlost.ckeditor.mention.MentionConfig;
import com.wontlost.ckeditor.mention.MentionFeed;
import com.wontlost.ckeditor.mention.MentionFeedItem;
import com.wontlost.ckeditor.views.CKEditorView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.wontlost.ckeditor.utils.Constant.*;

@Route(value = PAGE_CLASSIC_EDITOR, layout = CKEditorView.class)
@RouteAlias(value = PAGE_DEMO_CKEDITOR, layout = CKEditorView.class)
@PageTitle(TITLE_CLASSIC_EDITOR)
public class ClassicView extends VerticalLayout {

    public ClassicView() {
        super();
        getStyle().set("overflow", "auto");
        Config config = new Config();
        config.setImage(new String[][]{},
                "", new String[]{"full", "alignLeft", "alignCenter", "alignRight"},
                new String[]{"imageTextAlternative", "|",
                        "imageStyle:alignLeft",
                        "imageStyle:full",
                        "imageStyle:alignCenter",
                        "imageStyle:alignRight"}, new String[]{});
        MentionFeed mentionFeed = new MentionFeed();
        List<MentionFeed> mentionFeeds = new ArrayList<>();
        List<MentionFeedItem> mentionFeedItems = new ArrayList<>();
        MentionFeedItem mentionFeedItem = new MentionFeedItem();
        mentionFeedItem.setId("@Ryan");
        mentionFeedItem.setText("@Ryan Pang");
        mentionFeedItems.add(mentionFeedItem);
        mentionFeedItem = new MentionFeedItem();
        mentionFeedItem.setId("@Bar");
        mentionFeedItem.setText("@Barney");
        mentionFeedItems.add(mentionFeedItem);
        mentionFeedItem = new MentionFeedItem();
        mentionFeedItem.setId("@Marry");
        mentionFeedItem.setText("@Marry Ann");
        mentionFeedItems.add(mentionFeedItem);
        mentionFeedItem = new MentionFeedItem();
        mentionFeedItem.setId("@Ted");
        mentionFeedItem.setText("@Ted");
        mentionFeedItems.add(mentionFeedItem);
        mentionFeed.setFeed(mentionFeedItems);
        mentionFeed.setMarker("@");
        MentionConfig mentionConfig = new MentionConfig();
        mentionConfig.setDropdownLimit(4);
        mentionFeeds.add(mentionFeed);
        mentionConfig.setFeeds(mentionFeeds);
        config.setUiViewportOffset(56D);
        config.setMention(mentionConfig);
        config.setLanguage(Constants.Language.en_au, Constants.Language.en_gb, new Constants.TextPartLanguage[]{
                Constants.TextPartLanguage.ar, Constants.TextPartLanguage.de, Constants.TextPartLanguage.sr_latn,
                Constants.TextPartLanguage.fr, Constants.TextPartLanguage.ja, Constants.TextPartLanguage.uz,
                Constants.TextPartLanguage.af, Constants.TextPartLanguage.bg, Constants.TextPartLanguage.zh_cn});
        config.setRemovePlugins(Arrays.asList(Constants.Plugins.TableProperties, Constants.Plugins.WProofreader, Constants.Plugins.StandardEditingMode,
                Constants.Plugins.RestrictedEditingMode, Constants.Plugins.Markdown, Constants.Plugins.Pagination,
                Constants.Plugins.Minimap, Constants.Plugins.TableCellProperties, Constants.Plugins.ExportPdf, Constants.Plugins.ExportWord));
        config.setTable(List.of("tableColumn", "tableRow", "mergeTableCells"), List.of(), null, null);

        VaadinCKEditor editor = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = "<p>This is a classic editor example.</p>";
            builder.editorType = EditorType.CLASSIC;
            builder.width = "70%";
            builder.readOnly = true;
            builder.autosave = true;
            builder.waitingTime = 5000;
            builder.ghsEnabled = true;
            builder.hideToolbar=true;
            //builder.sync = false;
            //builder.overrideCssUrl="./styles/override.css";
            builder.config = config;
        }).createVaadinCKEditor();
        VaadinCKEditorAction.registerAction(VaadinCKEditorAction.AUTOSAVE, new MySaveAction(editor.getId()));
        editor.setLabel("Comment:");
        editor.setRequiredIndicatorVisible(true);
        editor.setErrorMessage("Please provide the content.");
        add(editor);

        Button changeReadonlyMode = new Button("change readonly mode");
        changeReadonlyMode.addClickListener((event -> {
            editor.setReadOnlyWithToolbarAction(!editor.isReadOnly());
        }));
        add(changeReadonlyMode);

        Button insertText = new Button("insert text");

        add(insertText);

        add(new Text("--------------Preview---------------"));
        VaadinCKEditor preview = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = editor.getValue();
            builder.editorType = EditorType.BALLOON;
            builder.width = "70%";
            builder.config = new Config();
            builder.ghsEnabled = true;
            //builder.overrideCssUrl="./styles/override1.css";
            config.setImage(new String[][]{}, "", new String[]{}, new String[]{}, new String[]{});
            builder.readOnly = true;
        }).createVaadinCKEditor();
        add(preview);
        editor.addValueChangeListener(e-> {
            preview.setValue(editor.getValue());
            if(e.getValue().isEmpty()) {
                editor.setErrorMessage("No content provided.");
            }
        });
        insertText.addClickListener((event -> {
            editor.insertText(" Wow! Amazing~ ");
        }));
//        Label label = new Label();
//        label.setWidth(editor.getWidth());
//        label.getElement().setProperty("innerHTML", editor.getValue());
//        editor.addValueChangeListener(e-> label.getElement().setProperty("innerHTML", e.getValue()));
//        add(label);
        add(new Text("--------------Preview---------------"));


        //Label content = new Label();
        //add(content);
        //content.setWidth(editor.getWidth());
        //Button save = new Button("save content text");
        //save.addClickListener((event -> {f
        //    content.getElement().setProperty("innerHTML", preview.getContentText());
        //}));
        //add(save);

        setAlignItems(Alignment.CENTER);
    }

}
