package edu.pitagoras.threads;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		String path = "/home/marcus/Desktop/Pitágoras/multas/";
		File diretorio = new File(path);
		File[] listaDeArquivos = diretorio.listFiles();
		for (int i = 0; i < listaDeArquivos.length; i++) {
			if (listaDeArquivos[i].isFile()) {
				String nomeArquivos = listaDeArquivos[i].getName();
				ProcessadorMultas p = new 
						ProcessadorMultas(path + nomeArquivos, i);
				Thread t = new Thread(p);
				t.start();
			}
		}
	}

}
