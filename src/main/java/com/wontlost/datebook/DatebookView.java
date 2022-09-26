package com.wontlost.datebook;

import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDateTime;

import static com.wontlost.ckeditor.utils.Constant.PAGE_DEMO_DATEBOOK;

/**
 * @author Ryan Pang
 * @date 4/15/2021
 */
@Route(value = PAGE_DEMO_DATEBOOK)
@JsModule("./styles/shared-styles.js")
@PageTitle("Datebook")
public class DatebookView  extends VerticalLayout {

    public DatebookView() {
        super();
        DatebookVaadin add2CalendarVaadin = new DatebookVaadin();
        BasicConfig basicConfig = new BasicConfig();
        basicConfig.setTitle("My Event");
        LocalDateTime localDateTime = LocalDateTime.now();
        basicConfig.setStart(DatebookUtil.someTime(localDateTime, 0, 6, 0));
        basicConfig.setEnd(DatebookUtil.someTime(localDateTime, 0, 10, 0));
        add2CalendarVaadin.setCalendarOptions(basicConfig);
        Alarm alarm = new Alarm();
        alarm.setAction(Action.AUDIO);
        alarm.setSummary("My event test");
        alarm.setDescription("My event test");
        Duration duration = new Duration();
        duration.setAfter(false);
        duration.setMinutes(5);
        Trigger trigger = new Trigger();
        trigger.setDuration(duration);
        alarm.setTrigger(trigger);
        Attach attach = new Attach();
        attach.setParams("FMTTYPE=audio/mp3");
        attach.setUrl("radio/otr.mp3");
        alarm.setAttach(attach);
        add2CalendarVaadin.setCalendarAlarm(alarm);
        add(new Label(), add2CalendarVaadin);
        setAlignItems(Alignment.CENTER);
    }

}
