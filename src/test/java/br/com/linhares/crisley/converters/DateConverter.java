package br.com.linhares.crisley.converters;

import cucumber.api.Transformer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter extends Transformer<Date> {

    public Date transform(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date retorno = format.parse(data);
            return retorno;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
