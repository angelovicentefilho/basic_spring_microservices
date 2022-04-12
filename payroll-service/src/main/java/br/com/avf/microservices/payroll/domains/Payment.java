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
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private String name;
    private BigDecimal dailyIncome;
    private Integer days;

    public BigDecimal getTotal() {
        return dailyIncome.multiply(BigDecimal.valueOf(days));
    }

}
