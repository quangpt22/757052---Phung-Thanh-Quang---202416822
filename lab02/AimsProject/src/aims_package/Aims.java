package aims_package;

public class Aims {

	public static void main(String[] args) {
		/*
		Cart anOrder = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.println("Total Cost is: ");
		System.out.println(anOrder.totalCost());
		
		anOrder.showCart();
		anOrder.removeDigitalVideoDisc(dvd2);
		anOrder.showCart();
		*/
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Shawshank Redemption", "Drama", "Frank Darabont", 142, 29.95f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 27.50f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 152, 25.95f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("12 Angry Men", "Drama", "Sidney Lumet", 96, 19.95f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Schindler's List", "History", "Steven Spielberg", 195, 30.95f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 24.50f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("The Good, the Bad and the Ugly", "Western", "Sergio Leone", 178, 22.95f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("Fight Club", "Drama", "David Fincher", 139, 23.95f);
		DigitalVideoDisc dvd11 = new DigitalVideoDisc("Forrest Gump", "Drama", "Robert Zemeckis", 142, 24.95f);
		DigitalVideoDisc dvd12 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 26.50f);
		DigitalVideoDisc dvd13 = new DigitalVideoDisc("Interstellar", "Science Fiction", "Christopher Nolan", 169, 27.50f);
		DigitalVideoDisc dvd14 = new DigitalVideoDisc("Se7en", "Crime", "David Fincher", 127, 23.50f);
		DigitalVideoDisc dvd15 = new DigitalVideoDisc("The Silence of the Lambs", "Thriller", "Jonathan Demme", 118, 24.50f);
		DigitalVideoDisc dvd16 = new DigitalVideoDisc("The Departed", "Crime", "Martin Scorsese", 151, 26.95f);
		DigitalVideoDisc dvd17 = new DigitalVideoDisc("Django Unchained", "Western", "Quentin Tarantino", 165, 26.95f);
		DigitalVideoDisc dvd18 = new DigitalVideoDisc("Gladiator", "Action", "Ridley Scott", 155, 25.95f);
		DigitalVideoDisc dvd19 = new DigitalVideoDisc("The Prestige", "Mystery", "Christopher Nolan", 130, 24.95f);
		DigitalVideoDisc dvd20 = new DigitalVideoDisc("Saving Private Ryan", "War", "Steven Spielberg", 169, 21.50f);
		DigitalVideoDisc dvd21 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 20.50f);
		DigitalVideoDisc dvd22 = new DigitalVideoDisc("The Empire Strikes Back", "Science Fiction", "Irvin Kershner", 124, 19.95f);
		DigitalVideoDisc dvd23 = new DigitalVideoDisc("City of God", "Crime", "Fernando Meirelles", 130, 19.95f);
		DigitalVideoDisc dvd24 = new DigitalVideoDisc("The Pianist", "Biography", "Roman Polanski", 150, 20.50f);
		DigitalVideoDisc dvd25 = new DigitalVideoDisc("Parasite", "Thriller", "Bong Joon Ho", 132, 20.95f);
		store.addToStore(dvd1);
		store.addToStore(dvd2);
		store.addToStore(dvd3);
		store.addToStore(dvd4);
		store.addToStore(dvd5);
		store.addToStore(dvd6);
		store.addToStore(dvd7);
		store.addToStore(dvd8);
		store.addToStore(dvd9);
		store.addToStore(dvd10);
		store.addToStore(dvd11);
		store.addToStore(dvd12);
		store.addToStore(dvd13);
		store.addToStore(dvd14);
		store.addToStore(dvd15);
		store.addToStore(dvd16);
		store.addToStore(dvd17);
		store.addToStore(dvd18);
		store.addToStore(dvd19);
		store.addToStore(dvd20);
		store.addToStore(dvd21);
		store.addToStore(dvd22);
		store.addToStore(dvd23);
		store.addToStore(dvd24);
		store.addToStore(dvd25);
		store.searchDVDByTitle("gOd");
		store.searchDVDByCategory("cRimE");
		store.searchDVDByPrice(23.5f, 33.2f);
	}

}
