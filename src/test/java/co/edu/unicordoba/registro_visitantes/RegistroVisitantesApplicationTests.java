package co.edu.unicordoba.registro_visitantes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.unicordoba.registro_visitantes.modelo.Visitante;

@SpringBootTest
class RegistroVisitantesApplicationTests {

	@Test
	void elContadorStaticEsCompartido() {
		int antes = Visitante.getTotalCreados();
		new Visitante("ana", 25);
		new Visitante("luis", 40);
		assertEquals(antes + 2, Visitante.getTotalCreados());
	}

	@Test
	void instanceofYCastSeguro() {
		Object o = new Visitante("marta", 16);
		assertTrue(o instanceof Visitante);
		if (o instanceof Visitante v) // patrón de tipo
			assertFalse(v.esMayorDeEdad());
		Object texto = "Hola";
		assertFalse(texto instanceof Visitante);
	}

}
