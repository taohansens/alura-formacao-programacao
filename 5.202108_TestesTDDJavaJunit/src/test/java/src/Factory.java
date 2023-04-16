package src;

import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Factory {

    public static Funcionario createFuncionario(){
        return new Funcionario("Funcionario", LocalDate.now(), new BigDecimal(100));
    }

    public static Funcionario createFuncionario(double salario){
        return new Funcionario("Funcionario", LocalDate.now(), new BigDecimal(salario));
    }

}
