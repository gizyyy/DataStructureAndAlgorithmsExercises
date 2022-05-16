import java.util.Optional;

public class DogAdopter extends AdoptManager<Dog> {

	@Override
	public Animal adopt() {
		Optional<Animal> firstDog = shelter.stream().filter(k -> {
			if (k instanceof Dog) {
				return true;
			}
			return false;
		}).findFirst();

		if (firstDog.isEmpty()) {
			return null;
		}
		Animal animal = firstDog.get();
		shelter.remove(animal);
		return animal;
	}

	@Override
	public boolean supports(Type type) {
		return type == Type.DOG;
	}

}
