package org.generation.italy;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.Random;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> carte = new ArrayList<>(); // elenco di tutte le carte
		HashSet<Integer> estratte = new HashSet<>(); // elenco delle posizioni estratte
		String[] semi = { "denari", "bastoni", "coppe", "spade" };
		float punteggioUtente = 0, punteggioBanco = 0, matta;
		boolean ripeti = true;
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		// genero le carte
		for (int s = 0; s < 4; s++)
			for (int i = 1; i <= 10; i++)
				carte.add(i + " di " + semi[s]);

		// turno UTENTE
		int pos;
		String risposta = "";

		do {
			do {
				pos = r.nextInt(40); // da 0 a 39
			} 
			while (estratte.contains(pos)); // se l'ho già estratta torno indietro
			
			estratte.add(pos); // non può essere più estratto
			System.out.println("E' uscito: " + carte.get(pos));

			if (pos == 9) 
			{
				System.out.println("Matta, scegli il tuo punteggio:(0.5, 1, 2, 3, 4, 5, 6, 7)");
				matta = Float.parseFloat(sc.nextLine());
				punteggioUtente += matta;
			}
			else
			{
				pos = pos % 10; // ho sempre un valore da 0 a 9 (ad es. se pos vale 23 => 3)
				if (pos < 7)
				{
					punteggioUtente += pos + 1;
				}
				else
				{
					punteggioUtente += 0.5f;
				}
			}
			System.out.println("Punteggio: " + punteggioUtente);
			if (punteggioUtente > 7.5f)
			{
				System.out.println("Hai sballato!");
				punteggioUtente = 0f;
			}
			else if (punteggioUtente < 7.5f)
			{
				System.out.println("\nVuoi un'altra carta(si/no)?");
				risposta = sc.nextLine();
			}
			else if (punteggioUtente == 7.5)
			{
				System.out.println("BRAVOOO, hai fatto 7eMezzo");
			}
		}
		while (risposta.equals("si") && punteggioUtente < 7.5);
		System.out.println("tocca al banco, riuscirà batterti?");
		
		// turno COMPUTER
		do {
			do {
				pos = r.nextInt(40); // da 0 a 39
			}
			while (estratte.contains(pos)); // se l'ho già estratta torno indietro
			
			estratte.add(pos); // non può essere più estratto
			System.out.println("Il banco ha: " + carte.get(pos));

			if (pos == 9) 
			{
				System.out.println("Matta, scegli il tuo punteggio:(0.5, 1, 2, 3, 4, 5, 6, 7)");
				matta = Float.parseFloat(sc.nextLine());
				punteggioUtente += matta;
			}
			else
			{
				pos = pos % 10; // ho sempre un valore da 0 a 9 (ad es. se pos vale 23 => 3)
				if (pos < 7)
				{
					punteggioBanco += pos + 1;
				}
				else
				{
					punteggioBanco += 0.5f;
				}
			}
			
			System.out.println("Punteggio: " + punteggioBanco);
			if (punteggioBanco > 7.5f)
			{
				System.out.println("Hai sballato! Vince l'utente");
			}
			else if (punteggioBanco == 7.5f)
			{
				System.out.println("IL BANCO VINCE");
				ripeti = false;
			}
			else if (punteggioBanco == punteggioUtente)
			{
				System.out.println("Vince il banco, pareggio");
				ripeti = false;
			}
			else if (punteggioBanco > punteggioUtente && punteggioBanco < 7.5f)
			{
				System.out.println("Il banco supera l'utente e vince");
				ripeti = false;
			}
			else if (punteggioBanco < punteggioUtente)
			{
				System.out.println("Il banco pesca ancora");
				ripeti = true;
			}
		} while (ripeti == true);
		
		System.out.println("Grazie e arrivederci!");
		sc.close();
	}

}