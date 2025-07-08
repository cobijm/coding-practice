package random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fussbook {

	public static void main(String[] args) throws FileNotFoundException {

		// Declare then scan the file (use either "network_fussbook.txt" or "network_instaface.txt")
		File f = new File("network_fussbook.txt");
		Scanner s = new Scanner(f);
		ArrayList<Integer> nodes = new ArrayList<>(); // Keep track of nodes (people)
		ArrayList<String> edges = new ArrayList<>(); // Keep track of edges (connections)

		// go through file
		while (s.hasNextLine()) {
			Scanner curLine = new Scanner(s.nextLine());

			int firstPerson = curLine.nextInt(); // #
			curLine.next(); // is
			curLine.next(); // friends
			curLine.next(); // with
			int secondPerson = curLine.nextInt(); // #

			// check if connection already exists, if not add it
			if (!edges.contains(" " + firstPerson + " , " + secondPerson + " ")
					&& !edges.contains(" " + secondPerson + " , " + firstPerson + " ")) {
				edges.add(" " + firstPerson + " , " + secondPerson + " ");
			}

			// check if person already exists, if not add it
			if (nodes.contains(firstPerson) == false) {
				nodes.add(firstPerson);
			}
			if (nodes.contains(secondPerson) == false) {
				nodes.add(secondPerson);
			}
			curLine.close();

		}
		s.close();

		int highest = 0; // number of highest edges
		int mostWellConnected = 0; // most well connected node
		for (int i = 0; i < nodes.size(); i++) {
			int curHighest = 0; // person with current highest edges
			for (String temp : edges) {
				String connection = nodes.get(i).toString();
				if (temp.contains(" " + connection + " "))
					curHighest++;
				if (curHighest > highest) {
					highest = curHighest;
					mostWellConnected = nodes.get(i); // get the person with most edges
				}
			}

		}
		System.out.println("Nodes: " + nodes.size());
		System.out.println("Edges: " + edges.size());
		System.out.println("Most well-connected Person: " + mostWellConnected);

	}

}
