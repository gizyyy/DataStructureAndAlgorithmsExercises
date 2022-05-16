import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public abstract class AdoptManager<E extends Animal> {

	public static PriorityBlockingQueue<Animal> shelter;

	public AdoptManager() {
		if (shelter == null) {
			Comparator<Animal> comparing = Comparator.comparing(Animal::getOrder);
			shelter = new PriorityBlockingQueue<Animal>(100, comparing);
			shelter.add(new Dog("mini", shelter.size()));
			shelter.add(new Dog("tini", shelter.size()));
			shelter.add(new Cat("boncuk", shelter.size()));
			shelter.add(new Dog("rini", shelter.size()));
			shelter.add(new Cat("zeytin", shelter.size()));
		}
	}

	public abstract Animal adopt();

	public abstract boolean supports(Type type);

	public void putAnimalToShelter(E a) {
		int currentPrio = shelter.size();
		a.setOrder(currentPrio);
		shelter.add(a);
	}
}
