package outros;

import java.util.Scanner;

public class Monitor implements Runnable {
	
	private Thread th;
	private boolean monitorando;

	public Monitor() {
		monitorando = true;
		th = new Thread(this);
	}

	public void inciar() {
		th.start();
	}

	public void parar() {

		monitorando = false;
		th.interrupt();
		try {
			th.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void run() {
		System.out.println("Iniciando monitoramento.");
		while (monitorando == true) {
			// verifica se sistema alvo ainda está em execução
			System.out.println("Monitorando.");
			if (th.isInterrupted() == true) {
				System.out.println("Parando monitoramento.");
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				monitorando = false;
			}
		}
	}

	public static void main(String[] args) {
		Monitor monitor = new Monitor();
		monitor.inciar();
		Scanner sc = new Scanner(System.in);

		boolean monitorar = true;
		do {
			System.out.println("Continuar monitoramento S/N?");
			String resp = sc.next();
			if (resp.equalsIgnoreCase("N") == true) {
				monitorar = false;
				monitor.parar();
			}
		} while (monitorar == true);
		sc.close();
	}
}