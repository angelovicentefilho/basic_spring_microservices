package br.com.avf.microservices.payroll.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable {
    private Long id;
    private String name;
    private BigDecimal dailyIncome;
}
