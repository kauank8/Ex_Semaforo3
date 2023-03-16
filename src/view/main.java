package view;

import java.util.concurrent.Semaphore;

import Objetos.Escuderia;
import Objetos.Voltas;
import controller.CorridaController;

public class main {

	public static void main(String args[]) {
		Semaphore semaforo=new Semaphore(5);
		Semaphore semaforo2=new Semaphore(1);
		Escuderia[] escu = new Escuderia[14];
		Voltas[] voltas = new Voltas[14];
		
		for(int i=0;i<14;i++) {
			escu[i]=new Escuderia();
			voltas[i]=new Voltas();
		}
		for(int i=0;i<14;i++) {
			Thread corrida = new CorridaController(i,semaforo,escu,semaforo2,voltas);
			corrida.start();
		}

	}

}
