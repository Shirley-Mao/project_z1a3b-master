This application is a model of an animal hospital. Keep records for each animal. Possible features include different 
types of animals, age of the animal, medication needed for the animal, listing all animals with a common 
sickness, listing all animals under the care of a specific veterinarian; visualization of the animal record.
People working in an animal hospital can use it.
This project interests me because with all the different animals in the animal hospital, it is often hard to keep track 
with every one of them. Therefore, by designing this application, veterinarians can quickly get a overall health about 
the animal using this application.
# Animal Records



## User Stories

A *bulleted* list:
- As a user, I want to be able to add a new animal to the animal record.
- As a user, I want to be able to add a sickness case for an animal on my animal record.
- As a user, I want to be able to see the sickness cases an animal has.
- As a user, I want to be able to see the number of animals on my record.
- As a user, I want to be able to see the information of an animal on my record.
- As a user, I want to be able to save my animal records.
- As a user, I want to be able to optionally load my animal records from file when the program starts


## Instruction for Grader

- Press "Add Animal" button, then you can add an animal by entering its name, type and age.
- Press "Add Sickness case" button, then you can add a sickness case to an animal by entering its name,
 sickness, medication and veterinarian name.
- Press "Total # of animals" button, then you can check the total number of animals on record.
- Press "View Animal" button, then you can check the information about the animal by entering its name.
- Press "View sickness case" button, then you can check the sickness case of the animal by entering its name.
- Press "save" button to save all the changes to file. (the changes on file will be shown after app is closed)
- The Visual component of the project is in "View Animal". (try entering "lily") If the animal is a cat, a cat image 
will be displayed with its information. If the animal is a dog, a dog image will be displayed with its information. 
If the animal is a bird, a bird image will be displayed with its information. (so far there's only these three animals)

## Phase 4: Task 2

- The option I chose to implement is "Test and design a class that is robust".
- In the AnimalRecord class, the getAnimal() method have a robust design. It throws an AnimalNotFoundException when the 
animal is not in the animal record.

## Phase 4: Task 3

- Improvement 1: To increase Cohesion, I removed the addSicknessCase methods in Animal Class and AnimalRecord Class, and 
moved the method to the SicknessCase Class. Now AnimalRecord class only deal with the list of animals, Animal class only
deal with information of an animal, and SicknessCase class deals with adding and viewing the sickness of the animal.
- Improvement 2: To decrease Coupling, I added an abstract class called Window in the UI package and let these window classes
extend this class. In this way, AppLayout class calls an abstract class to do a job, it indirectly called these pop up window
classes without depending on them.

