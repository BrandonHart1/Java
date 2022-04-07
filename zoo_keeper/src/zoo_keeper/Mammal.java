package zoo_keeper;

class Mammal
{
	public int energyLevel = 100;
	
	
	public int displayEnergy()
	{
		System.out.println("Energy Level: " + energyLevel);
		return energyLevel;
	}
	
	public int throwSomething()
	{
		System.out.println("The gorilla has thrown something " + energyLevel);
		energyLevel -= 5;
		return energyLevel;
	}
	
	public int eatBananas()
	{
		System.out.println("The gorilla is satisfied " + energyLevel);
		energyLevel += 10;
		return energyLevel;
	}
	
	public int climb()
	{ 
		System.out.println("The gorilla has climbed a tree " + energyLevel);
		energyLevel -= 10;
		return energyLevel;
	}
}