package br.com.linhares.crisley.steps;

import br.com.linhares.crisley.converters.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AprenderCucumberSteps {

    @Dado("^que criei o arquivo corretamente$")
    public void queCrieiOArquivoCorretamente() {
    }

    @Quando("^executá-lo$")
    public void executáLo() {
    }

    @Então("^a especificação deve finalizar com sucesso$")
    public void aEspecificaçãoDeveFinalizarComSucesso(){
    }

    private int contador = 0;

    @Dado("^que o valor do contador é (\\d+)$")
    public void queOValorDoContadorÉ(int arg0) {
        contador = arg0;
    }

    @Quando("^eu incrementar em (\\d+)$")
    public void euIncrementarEm(int arg0) {
        contador = contador + arg0;
    }

    @Então("^o valor do contador será (\\d+)$")
    public void oValorDoContadorSerá(int arg0) {
        Assert.assertEquals(arg0, contador);
    }

    Date entrega = new Date();

    @Dado("^que o prazo de entrega é (.*)$")
    public void queOPrazoDeEntregaÉ(@Transform(DateConverter.class) Date data) {
        entrega = data;
    }

    @Quando("^a entrega atrasar em (\\d+) (dia|dias|mês|meses)$")
    public void aEntregaAtrasarEmDias(int periodo, String tempo) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(entrega);
        if(tempo.equals("dias")){
            calendar.add(Calendar.DAY_OF_MONTH, periodo);
        }
        if(tempo.equals("meses")){
            calendar.add(Calendar.MONTH, periodo);
        }
        entrega = calendar.getTime();
    }

    @Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
    public void aEntregaSeráEfetuadaEm(String data) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = format.format(entrega);
        Assert.assertEquals(data, dataFormatada);
    }

    @Dado("^que o ticket( especial)? é (A.\\d{3})$")
    public void queOTicketÉAF(String tipo, String codigo) {
        
    }

    @Dado("^que o valor da passagem é R\\$ (.*)$")
    public void queOValorDaPassagemÉR$(Double valor) {
        
    }

    @Dado("^que o nome do passageiro é \"(.{5,20})\"$")
    public void queONomeDoPassageiroÉ(String nome) throws Throwable {
    }

    @Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
    public void queOTelefoneDoPassageiroÉ(String telefone) {
        
    }

    @Quando("^criar os steps$")
    public void criarOsSteps() {
        
    }

    @Então("^o teste vai funcionar$")
    public void oTesteVaiFuncionar() {
    }
}
