package com.wontlost.ckeditor.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.wontlost.ckeditor.views.balloon.BalloonView;
import com.wontlost.ckeditor.views.classic.ClassicView;
import com.wontlost.ckeditor.views.decoupled.DecoupledView;
import com.wontlost.ckeditor.views.dialog.DialogView;
import com.wontlost.ckeditor.views.inline.InlineView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.wontlost.ckeditor.utils.Constant.*;

/**
 * The main view is a top-level placeholder for other views.
 */
@JsModule("./styles/shared-styles.js")
public class CKEditorView extends AppLayout{

    private final Tabs menu;
    private static Tab selected;

    public CKEditorView() {
        this.setDrawerOpened(false);
        Span appName = new Span();
        Image portalImage = new Image("icons/banner.png", "Portal Image");
        portalImage.setWidth("120px");
        portalImage.setHeight("38px");
        appName.add(portalImage);
        appName.addClassName("hide-on-mobile");

        menu = createMenuTabs();
        menu.setSelectedTab(selected);
        this.addToNavbar(appName);
        this.addToNavbar(true, menu);
    }

    private static Tabs createMenuTabs() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.add(getAvailableTabs());
        //tabs.add(donateButton());
        return tabs;
    }

    private static Tab[] getAvailableTabs() {
        final List<Tab> tabs = new ArrayList<>();
        selected = createTab(VaadinIcon.FILE_TEXT_O, TITLE_CLASSIC_EDITOR, ClassicView.class);
        selected.setSelected(true);
        tabs.add(selected);
        tabs.add(createTab(VaadinIcon.FILE_TEXT_O, TITLE_INLINE_EDITOR, InlineView.class));
        tabs.add(createTab(VaadinIcon.FILE_TEXT_O, TITLE_BALLOON_EDITOR, BalloonView.class));
        tabs.add(createTab(VaadinIcon.FILE_TEXT_O, TITLE_DECOUPLED_EDITOR, DecoupledView.class));
        tabs.add(createTab(VaadinIcon.FILE_TEXT_O, TITLE_DIALOG_EDITOR, DialogView.class));
        return tabs.toArray(new Tab[tabs.size()]);
    }

    private static Div donateButton() {
        Div div = new Div();
        div.getElement().setProperty("innerHTML", "<form action=\"https://www.paypal.com/cgi-bin/webscr\" " +
                "method=\"post\" target=\"_top\" style=\"display:flex; align-items:center; height: 100%; \"> "+
                "<input type=\"hidden\" name=\"cmd\" value=\"_s-xclick\" /> "+
                "<input type=\"hidden\" name=\"hosted_button_id\" value=\"7GG7XSYJ4TZFQ\" /> "+
                "<input type=\"image\" src=\"icons/money.png\" border=\"0\" name=\"submit\" style= \"width:48px; height:36px\"" +
                " title=\"PayPal - The safer, easier way to pay online!\" alt=\"Donate with PayPal button\" />"+
                "</form> ");
        return div;
    }

    private static Tab createTab(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
        return createTab(populateLink(new RouterLink(viewClass), icon, title));
    }

    private static Tab createTab(Component content) {
        final Tab tab = new Tab();
        tab.add(content);
        return tab;
    }

    private static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
        a.add(icon.create());
        a.add(title);
        return a;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        selectTab();
    }

    private void selectTab() {
        String target = RouteConfiguration.forSessionScope().getUrl(getContent().getClass());
        Optional<Component> tabToSelect = menu.getChildren().filter(tab -> {
            Component child = tab.getChildren().findFirst().get();
            return child instanceof RouterLink && ((RouterLink) child).getHref().equals(target);
        }).findFirst();
        tabToSelect.ifPresent(tab -> menu.setSelectedTab((Tab) tab));
    }

}
