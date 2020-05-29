package brewerydemo.brewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private UUID customerId;
    @NotBlank
    @Size(min=3,max=100)
    private String customerName;
}
