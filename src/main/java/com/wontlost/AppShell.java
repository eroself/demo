package com.wontlost;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.server.PWA;

import static com.wontlost.ckeditor.utils.Constant.VIEWPORT;

/**
 * @author Ryan Pang (ryan.pang@wontlost.com)
 */
@PWA(name = "Demo", shortName = "Demo", display = "fullscreen")
@Viewport(VIEWPORT)
public class AppShell implements AppShellConfigurator {

}
