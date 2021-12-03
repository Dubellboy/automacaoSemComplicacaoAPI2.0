package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa","12345678911","123467");
        silvioSantos = new Cliente("Silvio Santos","98765432112","11111111");

        contaXuxa = new Conta("0025","2254",2500.00,xuxa);
        contaSilvio = new Conta("0026", "2251",3500.00,silvioSantos);
    }

    @Test
    public void realizarTransacao(){

        contaXuxa.realizarTransferencia(1000.00,contaSilvio);

        assertEquals(1500.00,contaXuxa.getSaldo());
        assertEquals(4500.00,contaSilvio.getSaldo());
    }

    @Test
    public void validarTransferenciaInvalida(){

        boolean  resultado = contaXuxa.realizarTransferencia(3500.00,contaSilvio);

        assertFalse(resultado);

    }

}