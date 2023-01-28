package guru.bonacci5._1985.tringress.validation;

import java.math.BigDecimal;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class TrValidationResponse {

  private String poolType;
  private Boolean fromIsValid;
  private Boolean toIsValid;
  private BigDecimal fromsBalance;
}