package ua.training.controller.util;

import ua.training.constants.AttributeNames;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatTag extends TagSupport {
    private LocalDate date;
    private String language;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLocale(String locale) {
        this.language = locale;
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
