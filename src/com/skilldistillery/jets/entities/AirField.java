package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AirField {
	private ArrayList<Jet> jets;

	public AirField() {
		this.jets = new ArrayList<>();
		populateAirField(jets);
	}
	public ArrayList<Jet> getJets() {
		return jets;
	}
	public void populateAirField(ArrayList<Jet> jets) {
		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new FileReader("jets.txt"));
			String[] line = new String[5];
			double speed;
			int range;
			long price;
			String string = "";
			while ((string = bufIn.readLine()) != null) {
				line = string.split(",");
				speed = Double.parseDouble(line[2]);
				range = Integer.parseInt(line[3]);
				price = Long.parseLong(line[4]);
				if (line[0].equals("FighterJet")) {

					FighterJet jet = new FighterJet(line[1], speed, range, price);
					jets.add(jet);

				} else if (line[0].equals("CargoPlane")) {
					CargoPlane jet = new CargoPlane(line[1], speed, range, price);
					jets.add(jet);

				} else if (line[0].equals("PassengerJet")) {
					PassengerJet jet = new PassengerJet(line[1], speed, range, price);
					jets.add(jet);

				}

			}
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (bufIn != null) {
				try {
					bufIn.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
	}
	
}
