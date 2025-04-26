package com.example.patterns_banking.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class LowAmountAccount extends Account {
    private static final double DEPOSIT_FEE_RATE = 0.01; // 1% fee for deposits
    private static final double FREE_TRANSACTION_THRESHOLD = 100.0; // Si el monto supera este valor, se le debe descontar: DEPOSIT_FEE_RATE, sino, el deposito es gratis

    @Override
    public Double calculateDepositFee(Double amount) {

        if (amount > FREE_TRANSACTION_THRESHOLD) {
            return DEPOSIT_FEE_RATE*amount;
        }
        return 0.0;
//    Realizar logica de este método
//    Crear el factory para este tipo de cuentas
//    Crear un command para consultar todas las cuentas


//Crear logica del metodo
//Crear el factory
//Agregar al provider
//Crear el command para orquestar desde el service
    }
}
