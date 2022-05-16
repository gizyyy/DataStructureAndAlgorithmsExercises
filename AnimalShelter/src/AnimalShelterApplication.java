import java.util.ArrayList;
import java.util.List;

// Leetcode : There is an animal shelter keeps dog and cats, as FIFO. When someone wants to adopt a cat, oldest registered cat
// will be adopted. Same for the Dog.
public class AnimalShelterApplication {

	public static void main(String args[]) {
		CatAdopter catAdopter = new CatAdopter();
		DogAdopter dogAdopter = new DogAdopter();
		List<AdoptManager> adopters = new ArrayList<>();
		adopters.add(dogAdopter);
		adopters.add(catAdopter);

		// someone wants cat
		System.out.println(adopt(adopters, Type.CAT).getName() + " has been adopted");
		// someone wants dog
		System.out.println(adopt(adopters, Type.DOG).getName() + " has been adopted");
		// someone wants cat
		System.out.println(adopt(adopters, Type.CAT).getName() + " has been adopted");
	}

	public static Animal adopt(List<AdoptManager> adopters, Type type) {
		// small strategy paternish
		AdoptManager<Animal> adoptManager = adopters.stream().filter(a -> a.supports(type)).findFirst().get();
		return adoptManager.adopt();
	}

}
