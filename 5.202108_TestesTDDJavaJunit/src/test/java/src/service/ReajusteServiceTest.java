package src.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.Factory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteServiceTest {

    @Test
    public void readjustmentShouldBe3perCentWhenPerfomanceLessThanExpected(){
        ReajusteService service = new ReajusteService();
        double salary = 5000.0;

        BigDecimal expected = new BigDecimal(salary * 1.03).setScale(2, RoundingMode.HALF_UP);

        Funcionario funcionario = Factory.createFuncionario(salary);
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        Assertions.assertEquals(expected, funcionario.getSalario());
    }

    @Test
    public void readjustmentShouldBe15perCentWhenGoodPerformance(){
        ReajusteService service = new ReajusteService();
        double salary = 4578.0;

        BigDecimal expected = new BigDecimal(salary * 1.15).setScale(2, RoundingMode.HALF_UP);

        Funcionario funcionario = Factory.createFuncionario(salary);
        service.concederReajuste(funcionario, Desempenho.BOM);

        Assertions.assertEquals(expected, funcionario.getSalario());
    }

    @Test
    public void readjustmentShouldBe20perCentWhenGreatPerfomance(){
        ReajusteService service = new ReajusteService();
        double salary = 9350.0;

        BigDecimal expected = new BigDecimal(salary * 1.20).setScale(2, RoundingMode.HALF_UP);

        Funcionario funcionario = Factory.createFuncionario(salary);
        service.concederReajuste(funcionario, Desempenho.OTIMO);

        Assertions.assertEquals(expected, funcionario.getSalario());
    }
}
