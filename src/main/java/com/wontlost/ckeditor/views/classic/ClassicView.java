package com.wontlost.ckeditor.views.classic;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.wontlost.ckeditor.Config;
import com.wontlost.ckeditor.Constants;
import com.wontlost.ckeditor.Constants.EditorType;
import com.wontlost.ckeditor.VaadinCKEditor;
import com.wontlost.ckeditor.VaadinCKEditorBuilder;
import com.wontlost.ckeditor.mention.MentionConfig;
import com.wontlost.ckeditor.mention.MentionFeed;
import com.wontlost.ckeditor.mention.MentionFeedItem;
import com.wontlost.ckeditor.views.CKEditorView;

import java.util.ArrayList;
import java.util.List;

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
        config.setMention(mentionConfig);
        config.setLanguage(Constants.Language.en_au, Constants.Language.en_gb, new Constants.TextPartLanguage[]{
                Constants.TextPartLanguage.ar, Constants.TextPartLanguage.de, Constants.TextPartLanguage.sr_latn,
                Constants.TextPartLanguage.fr, Constants.TextPartLanguage.ja, Constants.TextPartLanguage.uz,
                Constants.TextPartLanguage.af, Constants.TextPartLanguage.bg, Constants.TextPartLanguage.zh_cn});

        VaadinCKEditor editor = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = "<p>This is a classic editor example.</p>";
            builder.editorType = EditorType.CLASSIC;
            builder.width = "70%";
            builder.readOnly = true;
            builder.ghsEnabled = true;
            builder.hideToolbar=true;
            builder.config = config;
        }).createVaadinCKEditor();
        editor.setLabel("Comment:");
        editor.setRequiredIndicatorVisible(true);
        editor.setErrorMessage("No content provided.");
        add(editor);

        Button changeReadonlyMode = new Button("change readonly mode");
        changeReadonlyMode.addClickListener((event -> {
            editor.setReadOnlyWithToolbarAction(!editor.isReadOnly());
        }));
        add(changeReadonlyMode);

        add(new Label("--------------Preview---------------"));
        VaadinCKEditor preview = new VaadinCKEditorBuilder().with(builder -> {
            builder.editorData = editor.getValue();
            builder.editorType = EditorType.BALLOON;
            builder.width = "70%";
            builder.config = new Config();
            builder.ghsEnabled = true;
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


        Label content = new Label();
        add(content);
        content.setWidth(editor.getWidth());
        Button save = new Button("save content text");
        save.addClickListener((event -> {
            content.getElement().setProperty("innerHTML", preview.getContentText());
        }));
        add(save);

        setAlignItems(Alignment.CENTER);
    }

}
