import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class Relogio {

	public static String Timestamp() {

		LocalDateTime agora = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return agora.format(formatter);
	}

	public static String tempoGasto(LocalDateTime tempo) {
		Duration diferenca = Duration.between(tempo, LocalDateTime.now());

		return horaString(diferenca);
	}

	public static String TempoMedio(LocalDateTime tempo, int repeticoes) {
		Duration diferenca = Duration.between(tempo, LocalDateTime.now());
		diferenca = diferenca.dividedBy(repeticoes);

		// Usa o Duration para calcular horas, minutos e segundos
		return horaString(diferenca);
	}

	private static String horaString(Duration diferenca) {
		// Usa o Duration para calcular horas, minutos e segundos
		long horas = diferenca.toHours();
		long minutos = diferenca.toMinutesPart();
		long segundos = diferenca.toSecondsPart();
		long mili = diferenca.toMillisPart();

		// Retorna no formato "HH:mm:ss" usando String.format
		return String.format("%02d:%02d:%02d.%02d", horas, minutos, segundos, mili);
	}
}