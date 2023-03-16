package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

import Objetos.Escuderia;
import Objetos.Voltas;

public class CorridaController extends Thread {
	private int carros;
	private Semaphore semaforo;
	private Escuderia[] escu;
	private static int y=0;
	private static int z=0;
	private Semaphore semaforo2;
	private String equipes[] = new String[7];
	private Voltas[] voltas;
	
	public CorridaController(int carros,Semaphore semaforo, Escuderia[] escu,Semaphore semaforo2,Voltas[] voltas) {
		this.carros=carros;
		this.semaforo=semaforo;
		this.escu=escu;
		this.semaforo2=semaforo2;
		this.voltas=voltas;
	}
	
	@Override
	public void run() {
		//preenche escuderia 
		escuderias();
		//------------------------------------->
		
		//Mostra Escuderias
		MostrarEscuderia mostraescu = new MostrarEscuderia(escu,equipes);
		try {
			semaforo2.acquire();
			
			mostraescu.mostraescuderia();
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo2.release();
		}
		//--------------------------->
		
		//Tempo para inicio Corrida
		try {
			sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Start Corrida
		if(carros%2==0) {
		try {
			semaforo.acquire();
			corrida();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}
		else {
			try {
				sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				semaforo.acquire();
				corrida();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
		}
	}
	
	public void escuderias() {
		escu[y].carro=carros;
		y++;
		
		if(y==14) {
			String txt="";
			int x=0;
			for(int i=0;i<7;i++) {
				txt+=Integer.toString(escu[x].carro)+" ";
				x++;
				txt+=Integer.toString(escu[x].carro);
				equipes[i]=txt;
				txt="";
				x++;
			}
		}
		
	}
	
	public void corrida() {
		Random Gerador = new Random();
		System.out.println("O carro " + carros + " entrou na pista");
		int voltarapida=0;
		int volta[]=new int[3];
		
		for(int i=0;i<3;i++) {
			volta[i]=Gerador.nextInt(120)+30;
			System.out.println(" A volta do carro " + carros + " foi de " + volta[i] + ".s");
		}
		if(voltarapida==0){
		   voltarapida=volta[0];
		}
		for(int i=1;i<3;i++){
			if(volta[i]<voltarapida){
			voltarapida=volta[i];
			}
		}
		System.out.println("O carro " + carros + " saiu da pista ");
		voltas[z].carro=carros;
		voltas[z].voltamaisrapida=voltarapida;
		z++;
		
		//Gera Grid
		if(z==14) {
			System.out.println("Grid:");
			int aux;
			int carro1;
			for(int i =0;i<14;i++) {
				for(int m=0;m<14;m++) {
					if(voltas[i].voltamaisrapida<voltas[m].voltamaisrapida) {
						aux=voltas[m].voltamaisrapida;
						carro1=voltas[m].carro;		
						voltas[m].voltamaisrapida =voltas[i].voltamaisrapida;
						voltas[m].carro =voltas[i].carro;
						voltas[i].voltamaisrapida=aux;
						voltas[i].carro=carro1;
						}
					}
				}
					
				
				for(int i=0;i<14;i++) {
					System.out.println("Carro " + voltas[i].carro + " volta "+ voltas[i].voltamaisrapida);
				}
			}
		}
	}
		

		
	

