package br.com.avf.microservices.payroll.protocols;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentResponse {
    private String name;
    private BigDecimal dailyIncome;
    private Integer days;
    private BigDecimal total;
}
