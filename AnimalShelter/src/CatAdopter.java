import java.util.Optional;

public class CatAdopter extends AdoptManager<Cat> {

	@Override
	public Animal adopt() {
		Optional<Animal> firstCat = shelter.stream().filter(k -> {
			if (k instanceof Cat) {
				return true;
			}
			return false;
		}).findFirst();

		if (firstCat.isEmpty()) {
			return null;
		}
		Animal animal = firstCat.get();
		shelter.remove(animal);
		return animal;
	}

	@Override
	public boolean supports(Type type) {
		return type == Type.CAT;
	}

}
