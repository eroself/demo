package com.wontlost.anime;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import elemental.json.JsonObject;
import elemental.json.impl.JreJsonFactory;

import static com.wontlost.ckeditor.utils.Constant.PAGE_DEMO_ANIME;

/**
 * @author Ryan Pang
 * @date 4/15/2021
 */
@Route(value = PAGE_DEMO_ANIME)
@JsModule("./styles/shared-styles.js")
@PageTitle("Anime")
public class AnimeView extends VerticalLayout {

    public AnimeView() {
        super();
        Button button = new Button("Test");
        button.setId("testButton");
        button.setClassName("testButton");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(button);
        JsonObject jsonObject = new JreJsonFactory().createObject();
        jsonObject.put("targets", "#testButton");
        jsonObject.put("easing", "easeInOutQuad");
        jsonObject.put("width", "100%");
        jsonObject.put("direction", "alternate");
        jsonObject.put("loop", true);
        //AnimeVaadin animeVaadin = new AnimeVaadin(jsonObject);
        //add(animeVaadin);
        setAlignItems(Alignment.CENTER);
    }

}
