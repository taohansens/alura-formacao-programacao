package src.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Factory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BonusServiceTest {
    private BonusService service;
    @BeforeEach
    public void setUp() {
        this.service = new BonusService();
    }

    @Test
    void bonusShouldThrowIllegalArgumentExceptionEarnMoreThan1000() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionario = Factory.createFuncionario(25000.0);
            BigDecimal expected = new BigDecimal(0).setScale(2, RoundingMode.HALF_UP);;
            BigDecimal bonus = service.calcularBonus(funcionario);
        });
    }

    @Test
    void bonusShouldBe10perCentSalaryWhenEarnExactly1000() {
        double salary = 1000.0;
        BigDecimal expected = new BigDecimal(salary * 0.1).setScale(2, RoundingMode.HALF_UP);;

        Funcionario funcionario = Factory.createFuncionario(salary);

        BigDecimal bonus = service.calcularBonus(funcionario);

        Assertions.assertEquals(expected, bonus);
    }

    @Test
    void bonusShouldBe10perCentSalaryWhenEarnLessThan1000() {
        double salary = 2000.0;
        BigDecimal expected = new BigDecimal(salary * 0.1).setScale(2, RoundingMode.HALF_UP);;

        Funcionario funcionario = Factory.createFuncionario(salary);

        BigDecimal bonus = service.calcularBonus(funcionario);

        Assertions.assertEquals(expected, bonus);
    }
}