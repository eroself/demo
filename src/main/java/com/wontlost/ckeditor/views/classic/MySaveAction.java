package com.wontlost.ckeditor.views.classic;

import com.wontlost.ckeditor.AutosaveAction;

import java.util.Optional;

/**
 * @author Ryan Pang (ryan.pang@wontlost.com)
 * @date 20/04/2024
 */
public class MySaveAction extends AutosaveAction {

    Optional<String> id;

    MySaveAction(Optional<String> editorId) {
        id=editorId;
    }

    @Override
    public void accept(String editorData) {
        System.out.println("saving " + editorData +" for editor with id = "+ id);
    }
}
