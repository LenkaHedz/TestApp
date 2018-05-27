package ua.training.view;

import org.apache.log4j.Logger;
import ua.training.constants.AttributeNames;
import ua.training.controller.command.LoginCommand;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatTag extends TagSupport {
    private String language;
    private LocalDate date;

    public void setLocalDate(LocalDate date) {
        this.date = date;
    }

    public void setLanguage(String langCount) {
        this.language = langCount;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            if (language.equals(AttributeNames.RU)) {
                pageContext.getOut()
                        .write(date.format(DateTimeFormatter.ofPattern(AttributeNames.FORMAT_DATE_RU)));
            } else {
                pageContext.getOut()
                        .write(date.format(DateTimeFormatter.ofPattern(AttributeNames.FORMAT_DATE_EN)));
            }
        } catch (IOException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }
}