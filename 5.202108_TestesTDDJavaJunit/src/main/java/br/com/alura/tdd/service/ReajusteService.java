package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal reajuste = desempenho.percentualReajuste();

		BigDecimal valorReajuste = funcionario.getSalario().multiply(reajuste).setScale(2, RoundingMode.HALF_UP);
		funcionario.reajustarSalario(valorReajuste);
	}

}
