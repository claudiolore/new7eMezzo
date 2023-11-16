package org.generaton.italy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int a, b;
		double punteggio=0f;
		String risposta, carta;
		String[] segni = {"Denari", "Bastoni", "Coppe", "Spade"};
		ArrayList<Integer> valori =new ArrayList<>();
		ArrayList<String> mazzo=new ArrayList<>();
		ArrayList<String> scarto=new ArrayList<>();
		
	//genero mazzo	
		for(int j=0;j<4;j++)
		{
			for (int i=1;i<11;i++)
			{
				valori.add(i);
				mazzo.add(i+" "+segni[j]);
			}
			
		}
		
	//inizio gioco	
		System.out.println("Benvenuto a 7eMezzo");
	do
	{
		do
		{
			do
			{
				a=r.nextInt(40);
				b=r.nextInt(4);
				carta=valori.get(a)+" "+segni[b];
				
				System.out.println("la tua carta è: "+ carta);
				
				if(valori.get(a)<=7)
				{
					punteggio=punteggio+valori.get(a);
					System.out.println("il tuo punteggio è: "+punteggio);
				}
				else
				{
					punteggio=punteggio+0.5;
					System.out.println("il tuo punteggio è: "+punteggio);
				}
			}while(scarto.contains(carta));
			
			mazzo.add(carta);
			
			if(punteggio>7.5)
			{
				System.out.println("HAI CANNATO");
				break;				
			}
			
			System.out.println("vuoi un'altra carta?(si/no)");
			risposta=sc.nextLine();
		
										
		}while(risposta.equals("si"));
		
	System.out.println("Vuoi giocare ancora?");
		
	}while(risposta.equals("si"));
		
		
	}

}
