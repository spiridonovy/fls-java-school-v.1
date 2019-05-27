##Deadline: June 4 2019


Implement a study scheduling application in which procedures for treatment of patients performed by doctors are planned. The data is modelled via domain objects.


The application provides an interface for the following operations:
- Adding patients
- Scheduling procedures
- Updating status of procedure


##Domain objects:
- Patient
	* Id (mandatory)
	* Name (mandatory)
	* Sex (optional)
	* Day of Birth (optional)
- Study
	* Id (mandatory)
	* Patient (mandatory)
	* Description (mandatory)
	* Status [Planned, In Progress, Finished] (mandatory)
	* Planned Start time (mandatory)
	* Estimated End time (optional)
-  Doctor
	* Id (mandatory)
	* Name (mandatory)
- Room
	* Id (mandatory)
	* Name (mandatory)


##Technologies: Spring-Boot (**spring data jpa, spring web**)


##Useful links:
- http://spring-projects.ru/guides/rest-service/
- https://spring.io/guides/gs/accessing-data-jpa/
