package controller;

import Objetos.Escuderia;

public class MostrarEscuderia {
	private Escuderia[] escu;
	private static int x=0;
	private static int i=0;
	private String txt;
	private String vt[];
	public MostrarEscuderia(Escuderia[] escu, String vt[]) {
		this.escu=escu;
		this.vt=vt;
	}
	public void mostraescuderia() {	
		if(x==0) {
	System.out.println("BEM VINDO AO GRANDE GP FATEC ZL HOJE TEREMOS A DEFINICAO DA POLI POSITION, "
		+ "PARA COMECAR AS ESCUDERIAS VEM COM OS SEGUINTES CARROS");}
	if(x==13) {
		System.out.println("A escuderia Ferrari possui os seguintes carros " + vt[0] );
		System.out.println("A escuderia Mercedes possui os seguintes carros " + vt[1] );
		System.out.println("A escuderia Red Bull possui os seguintes carros " + vt[2]  );
		System.out.println("A escuderia Mcleren possui os seguintes carros " + vt[3]  );
		System.out.println("A escuderia Alpha possui os seguintes carros " + vt[4]  );
		System.out.println("A escuderia Rass possui os seguintes carros " + vt[5]  );
		System.out.println("A escuderia Aston Martin possui os seguintes carros " + vt[6]  );
	}
	x++;

}
}
	
