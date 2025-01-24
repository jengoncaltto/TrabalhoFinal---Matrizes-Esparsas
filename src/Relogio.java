import java.time.LocalTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Relogio {

	public static String Timestamp() {

		LocalTime agora = LocalTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return agora.format(formatter);
	}

	public static String Passou(LocalTime tempo) {
		Duration diferenca = Duration.between(tempo, LocalTime.now());

		// Usa o Duration para calcular horas, minutos e segundos
		long horas = diferenca.toHours();
		long minutos = diferenca.toMinutesPart();
		long segundos = diferenca.toSecondsPart();

		// Retorna no formato "HH:mm:ss" usando String.format
		return String.format("%02d:%02d:%02d", horas, minutos, segundos);
	}
}